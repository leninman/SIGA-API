/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models.DTOS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Long idCurso;
    private Long idAnnio;
    private Long idSec;
    private Long idAnnioEsc;
    private Long idTurno;
    private String annio;
    private String intAnnioEsc;
    private String seccion;
    private String turno;
    private String nivel;
    private String especialidad;
}
