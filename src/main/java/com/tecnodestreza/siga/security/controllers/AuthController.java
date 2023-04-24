package com.tecnodestreza.siga.security.controllers;

import com.tecnodestreza.siga.security.dto.JwtDto;
import com.tecnodestreza.siga.security.dto.LoginUsuario;
import com.tecnodestreza.siga.security.dto.Mensaje;
import com.tecnodestreza.siga.security.dto.NuevoUsuario;
import com.tecnodestreza.siga.security.entity.Rol;
import com.tecnodestreza.siga.security.entity.Usuario;
import com.tecnodestreza.siga.security.enums.RolNombre;
import com.tecnodestreza.siga.security.jwt.JwtProvider;
import com.tecnodestreza.siga.security.service.RolService;
import com.tecnodestreza.siga.security.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final RolService rolService;
    private final JwtProvider jwtProvider;
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario){
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<>(new Mensaje("Usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity<>(new Mensaje("El email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario=new Usuario();
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setApellido(nuevoUsuario.getApellido());
        usuario.setNombreUsuario(nuevoUsuario.getNombreUsuario());
        usuario.setEmail(nuevoUsuario.getEmail());
        usuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
        usuario.setNumIntentosFallidos(nuevoUsuario.getNumIntentosFallidos());
        usuario.setActivo(nuevoUsuario.getActivo());
        usuario.setFechaUltimaConexion(new Date());
        Rol rol=rolService.getRolByRolName(nuevoUsuario.getRoles().get(0).getRolNombre()).get();
        List<Rol> rolesList=new ArrayList<>();
        rolesList.add(rol);
        usuario.setRoles(rolesList);
        usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(new Mensaje("Usuario creado"),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario){
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
