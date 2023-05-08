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
@Table(name = "docentes")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Long id;
	@Basic(optional = false)
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	@Basic(optional = false)
	@Column(name = "numero_documento")
	private String numeroDocumento;
	@Basic(optional = false)
	@Column(name = "primer_nombre")
	private String primerNombre;
	@Column(name = "segundo_nombre")
	private String segundoNombre;
	@Basic(optional = false)
	@Column(name = "primer_apellido")
	private String primerApellido;
	@Column(name = "segundo_apellido")
	private String segundoApellido;
	@Basic(optional = false)
	private String sexo;
	@Basic(optional = false)
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Basic(optional = false)
	private String edad;
	@Basic(optional = false)
	private String direccion;
	@Basic(optional = false)
	private String telefono;
	@Basic(optional = false)
	private String email;
	@Basic(optional = false)
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	@Basic(optional = false)
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	@Basic(optional = false)
	private Boolean activo;
	@Basic(optional = false)
	private String condicion;
	@Basic(optional = false)
	@Column(name = "estado_civil")
	private String estadoCivil;
	@Basic(optional = false)
	private String pregrado1;
	private String pregrado2;
	private String curso1;
	private String curso2;
	private String curso3;
	private String curso4;
	@Basic(optional = false)
	@Column(name = "graduado_pregrado1")
	private String graduadoPregrado1;
	private String categoria;
	@Basic(optional = false)
	@Column(name = "tiempo_de_servicio")
	private Integer tiempoDeServicio;
	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();
	}
}
