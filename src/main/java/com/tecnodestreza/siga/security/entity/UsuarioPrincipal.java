package com.tecnodestreza.siga.security.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String apellido;
    private String nombreUsuario;
    private String email;
    private String password;
    private Integer numIntentosFallidos;
    private Boolean activo;
    private Date fechaUltimaConexion;
    private Collection<? extends GrantedAuthority> authorities;

   public static UsuarioPrincipal build(Usuario usuario){
       List<GrantedAuthority>  userAuthorities=
               usuario.getRoles().stream().map(rol->new SimpleGrantedAuthority(rol.getRolNombre())).collect(Collectors.toList());
   return new UsuarioPrincipal(
           usuario.getNombre(),
           usuario.getApellido(),
           usuario.getNombreUsuario(),
           usuario.getEmail(),
           usuario.getPassword(),
           usuario.getNumIntentosFallidos(),
           usuario.getActivo(),
           usuario.getFechaUltimaConexion(),
           userAuthorities
   );
   }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
