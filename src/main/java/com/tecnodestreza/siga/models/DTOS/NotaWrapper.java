/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnodestreza.siga.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaWrapper implements Serializable {
    private Long idAl;
    private String tipoDocAl;
    private String numDocAl;
    private String primNombAl;
    private String segNombAl;
    private String primApellAl;
    private String segApellAl;
    private Long idCurso;
    private String annio;
    private String intAnnioEsc;
    private String seccion;
    private String turno;
    private String nivel;
    private String especialidad;
    private Long idMateria;
    private String codigoMat;
    private String nombreMat;
    private Long idPrf;
    private String tipoDocPrf;
    private String numDocPrf;
    private String primNombPrf;
    private String primApellPrf;
    private String segNombPrf;
    private String segApellPrf;
    private Long idLapso;
    private String periodo;
    private String lapsodescripcion;
    private Float nota;
    private Float porcentaje;
}
