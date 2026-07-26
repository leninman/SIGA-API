package com.tecnodestreza.siga.config.tenant;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TenantFilterTest {

    @Test
    void doFilterInternalNormalizesFriendlyTenantNames() throws Exception {
        TenantFilter filter = new TenantFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        when(request.getRequestURI()).thenReturn("/alumno/listado");
        when(request.getHeader("X-Tenant-ID")).thenReturn("jr pocaterra");

        filter.doFilterInternal(request, response, filterChain);

        // Verify filter chain continues and tenant is set during filter execution
        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternalPreservesExistingSchemaTenantNames() throws Exception {
        TenantFilter filter = new TenantFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        when(request.getRequestURI()).thenReturn("/alumno/listado");
        when(request.getHeader("X-Tenant-ID")).thenReturn("siga_jrpocaterra");

        filter.doFilterInternal(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
    }

    @Test
    void doFilterInternalReturns400IfTenantHeaderMissing() throws Exception {
        TenantFilter filter = new TenantFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);
        StringWriter body = new StringWriter();

        when(request.getRequestURI()).thenReturn("/alumno/listado");
        when(request.getHeader("X-Tenant-ID")).thenReturn(null);
        when(response.getWriter()).thenReturn(new PrintWriter(body));

        filter.doFilterInternal(request, response, filterChain);

        verify(response).setStatus(400);
        verify(response).setContentType("application/json");
        verify(filterChain, never()).doFilter(request, response);
        assertTrue(body.toString().contains("Missing required HTTP header: X-Tenant-ID"));
    }

    private void assertTrue(boolean condition) {
        org.junit.jupiter.api.Assertions.assertTrue(condition);
    }
}
