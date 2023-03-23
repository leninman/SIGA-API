/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Lenin
 */

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSO")
    private Long idCurso;
    
    @JoinColumn(name = "ID_ANNIO", referencedColumnName = "ID_ANNIO")
    @ManyToOne(optional = false)
    private Annio annio;
    
    @JoinColumn(name = "ID_ANNIO_ESC", referencedColumnName = "ID_ANNIO_ESC")
    @ManyToOne(optional = false)
    private AnnioEscolar annioEscolar;
    
    @JoinColumn(name = "ID_SEC", referencedColumnName = "ID_SEC")
    @ManyToOne(optional = false)
    private Seccion seccion;
    
    @JoinColumn(name = "ID_TURNO", referencedColumnName = "ID_TURNO")
    @ManyToOne(optional = false)
    private Turno turno;
    
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
   // private List<Alumno> alumnos;
    
    public Curso() {
    }

    public Curso(Long idCurso) {
        this.idCurso = idCurso;
    }


    public Curso(Long idCurso, Annio annio, AnnioEscolar annioEscolar, Seccion seccion, Turno turno) {
        this.idCurso = idCurso;
        this.annio = annio;
        this.annioEscolar = annioEscolar;
        this.seccion = seccion;
        this.turno = turno;
        //this.alumnos = alumnos;
    }

    public Curso(Annio annio, AnnioEscolar annioEscolar, Seccion seccion, Turno turno) {
        this.annio = annio;
        this.annioEscolar = annioEscolar;
        this.seccion = seccion;
        this.turno = turno;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Annio getAnnio() {
        return annio;
    }

    public void setAnnio(Annio annio) {
        this.annio = annio;
    }

    public AnnioEscolar getAnnioEscolar() {
        return annioEscolar;
    }

    public void setAnnioEscolar(AnnioEscolar annioEscolar) {
        this.annioEscolar = annioEscolar;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    /*public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }*/


}
