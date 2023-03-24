/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

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

    @Column(name = "FECHA_I")
    private Date fechaI;

    @Column(name = "FECHA_F")
    private Date fechaF;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annioEscolar")
    private List<Curso> cursos;

    public AnnioEscolar() {
    }

    public AnnioEscolar(Long idAnnioEsc, String intAnnioEsc, Date fechaI, Date fechaF, String status, List<Curso> cursos) {
        this.idAnnioEsc = idAnnioEsc;
        this.intAnnioEsc = intAnnioEsc;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.status = status;
        this.cursos = cursos;
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



    public Date getFechaI() {
		return fechaI;
	}

	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}

	public Date getFechaF() {
		return fechaF;
	}

	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
