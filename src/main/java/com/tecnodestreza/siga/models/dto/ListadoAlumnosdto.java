package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListadoAlumnosdto {
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String cursoAnnio;
    private String cursoSeccion;
    private String cursoPeriodoAcademico;
    private String cursoTurno;
    private String cursoNivel;

}
