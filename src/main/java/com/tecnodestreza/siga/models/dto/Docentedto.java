package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Docentedto {
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private Date fechaNacimiento;
    private String edad;
    private String direccion;
    private String codigoOperadoraTelefono;
    private String telefono;
    private String email;
    private String lugarDeNacimiento;
    private String nacionalidad;
    private Date fechaIngreso;
    private Date fechaCreacion;
    private Boolean activo;
    private String condicion;
    private String estadoCivil;
    private String pregrado1;
    private String pregrado2;
    private String curso1;
    private String curso2;
    private String curso3;
    private String curso4;
    private String graduadoPregrado1;
    private String categoria;
    private Integer tiempoDeServicio;
}
