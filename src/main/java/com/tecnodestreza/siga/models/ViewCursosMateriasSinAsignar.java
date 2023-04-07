package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * The persistent class for the view_cursos_materias_sin_asignar database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="view_cursos_materias_sin_asignar")
@NamedQuery(name="ViewCursosMateriasSinAsignar.findAll", query="SELECT v FROM ViewCursosMateriasSinAsignar v")
public class ViewCursosMateriasSinAsignar implements Serializable {
	private static final long serialVersionUID = 1L;
	private String annio;
	private String especialidad;
	@Column(name="ID_ANNIO")
	private BigInteger idAnnio;
	@Column(name="ID_CURSO")
	private BigInteger idCurso;
	@Column(name="ID_MAT")
	private BigInteger idMat;
	@Id
	@Column(name="ID_MAT_POR_CURSO")
	private String idMatPorCurso;
	private String materia;
	private String nivel;
	@Column(name="PERIODO_ESCOLAR")
	private String periodoEscolar;
	private String seccion;
}