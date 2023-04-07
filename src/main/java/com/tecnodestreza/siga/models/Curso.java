/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
