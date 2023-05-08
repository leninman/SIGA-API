package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Representantedto {
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private Date fechaNacimieno;
    private String edad;
    private String estadoCivil;
    private String direccion;
    private String empresaDondeTrabaja;
    private String direccionLaboral;
    private String telefono;
    private String telefonoEmpresa;
    private String email;
    private Boolean activo;
    private String profesion;
    private String ocupacion;
}
