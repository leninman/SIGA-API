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
import java.util.Date;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_RPR1", referencedColumnName = "ID_RPR")
	private Representante Rpr1;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_RPR2", referencedColumnName = "ID_RPR")
	private Representante Rpr2;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CURSO",referencedColumnName ="ID_CURSO" )
	private Curso curso;
	@Basic(optional = false)
	@Column(name = "PAR_RPR1")
	private String parRpr1;
	@Basic(optional = false)
	@Column(name = "PAR_RPR2")
	private String parRpr2;
	@Basic(optional = false)
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}
}
