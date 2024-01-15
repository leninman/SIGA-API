package com.tecnodestreza.siga.security.service;

import com.tecnodestreza.siga.security.entity.Usuario;
import com.tecnodestreza.siga.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    public Optional<Usuario> getUsuarioByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findUsuarioByNombreUsuario(nombreUsuario);
    }
    public Boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    public Boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    public void crearUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }


}
