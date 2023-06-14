package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaNotasAlumnodto {

    private String tipoDocumentoAlumno;
    private String numeroDocumentoAlumno;
    private String primerNombreAlumno;
    private String segundoNombreAlumno;
    private String primerApellidoAlumno;
    private String segundoApellidoAlumno;
    private String annio;
    private String periodo;
    private String seccion;
    private String turno;
    private List<NotaConsultadto> notas;




}
