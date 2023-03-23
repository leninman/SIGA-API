/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_AL")
	private Long idAl;
	@Basic(optional = false)
	@Column(name = "TIPO_DOC_AL")
	private String tipoDocAl;
	@Basic(optional = false)
	@Column(name = "NUM_DOC_AL")
	private String numDocAl;
	@Basic(optional = false)
	@Column(name = "PRIM_NOMB_AL")
	private String primNombAl;
	@Column(name = "SEG_NOMB_AL")
	private String segNombAl;
	@Basic(optional = false)
	@Column(name = "PRIM_APELL_AL")
	private String primApellAl;
	@Column(name = "SEG_APELL_AL")
	private String segApellAl;
	@Basic(optional = false)
	@Column(name = "SEXO_AL")
	private String sexoAl;
	@Basic(optional = false)
	@Column(name = "FECH_NAC_AL")
	@Temporal(TemporalType.DATE)
	private Date fechNacAl;
	@Basic(optional = false)
	@Column(name = "EDAD_AL")
	private String edadAl;
	@Basic(optional = false)
	@Column(name = "DIR_PPAL_AL")
	private String dirPpalAl;
	@Basic(optional = false)
	@Column(name = "DIR_SEC_AL")
	private String dirSecAl;
	@Basic(optional = false)
	@Column(name = "TLF_PPAL_AL")
	private String tlfPpalAl;
	@Basic(optional = false)
	@Column(name = "TLF_SEC_AL")
	private String tlfSecAl;
	@Basic(optional = false)
	@Column(name = "EMAIL_AL")
	private String emailAl;
	@Basic(optional = false)
	@Column(name = "FECH_ING_AL")
	@Temporal(TemporalType.DATE)
	private Date fechIngAl;
	@Basic(optional = false)
	@Column(name = "STATUS")
	private String status;
	@JoinColumn(name = "ID_RPR1", referencedColumnName = "ID_RPR")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Representante Rpr1;
	@Basic(optional = false)
	@Column(name = "PAR_RPR1")
	private String parRpr1;
	@JoinColumn(name = "ID_RPR2", referencedColumnName = "ID_RPR")
	@ManyToOne(fetch = FetchType.LAZY)
	private Representante Rpr2;
	@Basic(optional = false)
	@Column(name = "PAR_RPR2")
	private String parRpr2;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ID_CURSO")
	private Curso curso;
	@Basic(optional = false)
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}
	public Alumno() {
	}


	public Alumno(Long idAl, String tipoDocAl, String numDocAl, String primNombAl, String segNombAl, String primApellAl, String segApellAl, String sexoAl, Date fechNacAl, String edadAl, String dirPpalAl, String dirSecAl, String tlfPpalAl, String tlfSecAl, String emailAl, Date fechIngAl, String status, Representante rpr1, String parRpr1, Representante rpr2, String parRpr2, Curso curso, Date fechaCreacion) {
		this.idAl = idAl;
		this.tipoDocAl = tipoDocAl;
		this.numDocAl = numDocAl;
		this.primNombAl = primNombAl;
		this.segNombAl = segNombAl;
		this.primApellAl = primApellAl;
		this.segApellAl = segApellAl;
		this.sexoAl = sexoAl;
		this.fechNacAl = fechNacAl;
		this.edadAl = edadAl;
		this.dirPpalAl = dirPpalAl;
		this.dirSecAl = dirSecAl;
		this.tlfPpalAl = tlfPpalAl;
		this.tlfSecAl = tlfSecAl;
		this.emailAl = emailAl;
		this.fechIngAl = fechIngAl;
		this.status = status;
		Rpr1 = rpr1;
		this.parRpr1 = parRpr1;
		Rpr2 = rpr2;
		this.parRpr2 = parRpr2;
		this.curso = curso;
		this.fechaCreacion = fechaCreacion;
	}

	public Alumno(Long idAl) {
		this.idAl = idAl;
	}

	public Long getIdAl() {
		return idAl;
	}

	public void setIdAl(Long idAl) {
		this.idAl = idAl;
	}

	public String getTipoDocAl() {
		return tipoDocAl;
	}

	public void setTipoDocAl(String tipoDocAl) {
		this.tipoDocAl = tipoDocAl;
	}

	public String getNumDocAl() {
		return numDocAl;
	}

	public void setNumDocAl(String numDocAl) {
		this.numDocAl = numDocAl;
	}

	public String getPrimNombAl() {
		return primNombAl;
	}

	public void setPrimNombAl(String primNombAl) {
		this.primNombAl = primNombAl;
	}

	public String getSegNombAl() {
		return segNombAl;
	}

	public void setSegNombAl(String segNombAl) {
		this.segNombAl = segNombAl;
	}

	public String getPrimApellAl() {
		return primApellAl;
	}

	public void setPrimApellAl(String primApellAl) {
		this.primApellAl = primApellAl;
	}

	public String getSegApellAl() {
		return segApellAl;
	}

	public void setSegApellAl(String segApellAl) {
		this.segApellAl = segApellAl;
	}

	public String getSexoAl() {
		return sexoAl;
	}

	public void setSexoAl(String sexoAl) {
		this.sexoAl = sexoAl;
	}

	public Date getFechNacAl() {
		return fechNacAl;
	}

	public void setFechNacAl(Date fechNacAl) {
		this.fechNacAl = fechNacAl;
	}

	public String getEdadAl() {
		return edadAl;
	}

	public void setEdadAl(String edadAl) {
		this.edadAl = edadAl;
	}

	public String getDirPpalAl() {
		return dirPpalAl;
	}

	public void setDirPpalAl(String dirPpalAl) {
		this.dirPpalAl = dirPpalAl;
	}

	public String getDirSecAl() {
		return dirSecAl;
	}

	public void setDirSecAl(String dirSecAl) {
		this.dirSecAl = dirSecAl;
	}

	public String getTlfPpalAl() {
		return tlfPpalAl;
	}

	public void setTlfPpalAl(String tlfPpalAl) {
		this.tlfPpalAl = tlfPpalAl;
	}

	public String getTlfSecAl() {
		return tlfSecAl;
	}

	public void setTlfSecAl(String tlfSecAl) {
		this.tlfSecAl = tlfSecAl;
	}

	public String getEmailAl() {
		return emailAl;
	}

	public void setEmailAl(String emailAl) {
		this.emailAl = emailAl;
	}

	public Date getFechIngAl() {
		return fechIngAl;
	}

	public void setFechIngAl(Date fechIngAl) {
		this.fechIngAl = fechIngAl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Representante getRpr1() {
		return Rpr1;
	}

	public void setRpr1(Representante rpr1) {
		Rpr1 = rpr1;
	}

	public Representante getRpr2() {
		return Rpr2;
	}

	public void setRpr2(Representante rpr2) {
		Rpr2 = rpr2;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getParRpr1() {
		return parRpr1;
	}

	public void setParRpr1(String parRpr1) {
		this.parRpr1 = parRpr1;
	}

	public String getParRpr2() {
		return parRpr2;
	}

	public void setParRpr2(String parRpr2) {
		this.parRpr2 = parRpr2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
