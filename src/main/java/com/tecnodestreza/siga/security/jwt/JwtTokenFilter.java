package com.tecnodestreza.siga.security.jwt;

import com.tecnodestreza.siga.security.service.UsuarioDetailsServiceImpl;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    private final static Logger logger= LoggerFactory.getLogger(JwtTokenFilter.class);

    @Autowired
    JwtProvider provider;

    @Autowired
    UsuarioDetailsServiceImpl usuarioDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token=getToken(req);
            if(token != null && provider.validateToken(token)){
                String nombreUsuario=provider.obtenerNombreUsuarioFromToken(token);
                UserDetails userDetails =  usuarioDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        } catch (Exception e) {
            logger.error("Fallo en el método doFilter");
        }
        filterChain.doFilter(req,res);
    }


    private String getToken(HttpServletRequest request){
        String header=request.getHeader("Authorization");
        if(header != null ){
            return header.replace("Bearer ","");
        }else {
            return null;
        }
    }
}
