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
@Table(name = "representantes")
public class Representante implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
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
	@Column(name = "sexo")
	private String sexo;
	@Basic(optional = false)
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimieno;
	@Basic(optional = false)
	@Column(name = "edad")
	private String edad;
	@Basic(optional = false)
	@Column(name = "estado_civil")
	private String estadoCivil;
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	@Basic(optional = false)
	@Column(name = "empresa_donde_trabaja")
	private String empresaDondeTrabaja;
	@Basic(optional = false)
	@Column(name = "direccion_laboral")
	private String direccionLaboral;
	@Basic(optional = false)
	@Column(name = "telefono")
	private String telefono;
	@Basic(optional = false)
	@Column(name = "telefono_empresa")
	private String telefono_empresa;
	@Basic(optional = false)
	@Column(name = "email")
	private String email;
	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;
	@Column(name = "profesion")
	private String profesion;
	@Column(name = "ocupacion")
	private String ocupacion;
}