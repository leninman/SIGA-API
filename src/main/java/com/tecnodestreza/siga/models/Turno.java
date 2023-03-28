/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenin
 */

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TURNO")
    private Long idTurno;
    @Basic(optional = false)
    @Column(name = "TURNO")
    private String turno;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "turno")
    private List<Curso> cursos;

    public Turno() {
    }



    public Turno(Long idTurno, String turno) {
        this.idTurno = idTurno;
        this.turno = turno;
    }
    

    

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
