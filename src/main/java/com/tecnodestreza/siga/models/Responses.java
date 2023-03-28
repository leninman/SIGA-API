/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;

import com.tecnodestreza.siga.models.DTOS.*;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
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

    public Responses() {

    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public void setCurso(Optional<CursoDTO> curso) {
        this.curso = curso;
    }

    public Optional<CursoDTO> getCurso() {
        return curso;
    }

    public AnnioEscolarDTO getAnnioescolar() {
        return annioescolar;
    }

    public void setAnnioescolar(AnnioEscolarDTO annioescolar) {
        this.annioescolar = annioescolar;
    }

    public List<AlumnoDTO> getListadeAlumnos() {
        return listadeAlumnos;
    }

    public void setListadeAlumnos(List<AlumnoDTO> listadeAlumnos) {
        this.listadeAlumnos = listadeAlumnos;
    }

    public List<NotaParDTO> getNotasParciales() {
        return notasParciales;
    }

    public void setNotasParciales(List<NotaParDTO> notasParciales) {
        this.notasParciales = notasParciales;
    }

    public List<NotaPar> getNotasParciales2() {
        return notasParciales2;
    }
    public void setNotasParciales2(List<NotaPar> notasParciales) {
        this.notasParciales2 = notasParciales;
    }
    public List<NotaWrapper> getNotasWrapper() {
        return notasWrapper;
    }

    public void setNotasWrapper(List<NotaWrapper> notasWrapper) {
        this.notasWrapper = notasWrapper;
    }
    
    

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

}
