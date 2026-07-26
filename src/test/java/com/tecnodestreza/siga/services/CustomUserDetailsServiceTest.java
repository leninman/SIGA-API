package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Rol;
import com.tecnodestreza.siga.models.Usuario;
import com.tecnodestreza.siga.repo.IUsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomUserDetailsServiceTest {

    @Test
    void loadUserByUsernameUsesNombreUsuario() {
        IUsuarioRepo usuarioRepo = mock(IUsuarioRepo.class);
        CustomUserDetailsService service = new CustomUserDetailsService(usuarioRepo);

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("director");
        usuario.setPassword("hashed-password");
        usuario.setActivo(true);

        Rol rol = new Rol();
        rol.setRolNombre("ROLE_DIRECTOR");
        Set<Rol> roles = new HashSet<>();
        roles.add(rol);
        usuario.setRoles(roles);

        when(usuarioRepo.findByNombreUsuario("director")).thenReturn(Optional.of(usuario));

        UserDetails userDetails = service.loadUserByUsername("director");

        assertEquals("director", userDetails.getUsername());
        assertTrue(userDetails.getAuthorities().stream().anyMatch(authority -> authority.getAuthority().equals("ROLE_DIRECTOR")));
        verify(usuarioRepo).findByNombreUsuario("director");
        verify(usuarioRepo, never()).findByNombre(anyString());
    }
}
