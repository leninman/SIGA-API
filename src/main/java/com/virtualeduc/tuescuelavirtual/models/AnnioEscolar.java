/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "annio_escolar")

public class AnnioEscolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANNIO_ESC")
    private Long idAnnioEsc;
    @Basic(optional = false)
    @Column(name = "INT_ANNIO_ESC")
    private String intAnnioEsc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annioEscolar")
    private Collection<Curso> cursosCollection;

    public AnnioEscolar() {
    }

    public AnnioEscolar(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public AnnioEscolar(Long idAnnioEsc, String intAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
        this.intAnnioEsc = intAnnioEsc;
    }

    public Long getIdAnnioEsc() {
        return idAnnioEsc;
    }

    public void setIdAnnioEsc(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public String getIntAnnioEsc() {
        return intAnnioEsc;
    }

    public void setIntAnnioEsc(String intAnnioEsc) {
        this.intAnnioEsc = intAnnioEsc;
    }

    public Collection<Curso> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Curso> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    
}
