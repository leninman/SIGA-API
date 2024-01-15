package com.tecnodestreza.siga.security.dto;


import com.sun.istack.NotNull;
import com.tecnodestreza.siga.security.entity.Rol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class NuevoUsuario {
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String nombreUsuario;
    private String email;
    @NotNull
    private String password;
    private Integer numIntentosFallidos;
    private Boolean activo;
    private Date fechaUltimaConexion;
    private List<Rol> roles;
}
