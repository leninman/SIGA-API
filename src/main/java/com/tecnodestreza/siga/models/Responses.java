/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;
import com.tecnodestreza.siga.models.DTOS.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responses implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int responseCode;
    private String responseDescription;
    private AlumnoDTO alumno;
    private Optional<CursoDTO> curso;
    private AnnioEscolarDTO annioescolar;
    private List<AlumnoDTO> listadeAlumnos;
    private List<NotaParDTO> notasParciales;
    private List<NotaPar> notasParciales2;
    List<NotaWrapper> notasWrapper;
    private MateriaDTO materia;
    public ProfesorDTO profesor;
}
