package com.tecnodestreza.siga.security.entity;

import java.util.function.Function;

public class UsuarioDtoToUsuarioMapper implements Function<UsuarioDto,Usuario> {
    @Override
    public Usuario apply(UsuarioDto usuarioDto) {

        return new Usuario(
                usuarioDto.getNombres(),
                usuarioDto.getApellidos(),
                usuarioDto.getNombreUsuario(),
                usuarioDto.getClave(),
                usuarioDto.getCorreo()
        );
    }
}