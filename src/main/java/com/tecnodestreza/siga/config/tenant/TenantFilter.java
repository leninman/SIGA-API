package com.tecnodestreza.siga.config.tenant;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class TenantFilter extends OncePerRequestFilter {

    private static final String TENANT_HEADER = "X-Tenant-ID";

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        return path.contains("/swagger-ui") ||
               path.contains("/v3/api-docs") ||
               path.contains("/api-docs") ||
               path.contains("/swagger-resources") ||
               path.contains("/webjars");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String tenantId = request.getHeader(TENANT_HEADER);
        if (tenantId == null || tenantId.trim().isEmpty()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Bad Request\", \"message\": \"Missing required HTTP header: X-Tenant-ID\"}");
            return;
        }

        try {
            TenantContext.setCurrentTenant(normalizeTenant(tenantId));
            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }

    private String normalizeTenant(String tenantId) {
        String normalized = tenantId.trim().toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "");
        if (normalized.startsWith("siga")) {
            return normalized.length() > 4 ? "siga_" + normalized.substring(4) : "siga";
        }

        return "siga_" + normalized;
    }
}
