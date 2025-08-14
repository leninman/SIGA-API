package com.tecnodestreza.siga.security.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUsuario {
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;
}
