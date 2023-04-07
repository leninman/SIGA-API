package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * The persistent class for the view_materias_por_curso database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="view_materias_por_curso")
@NamedQuery(name="ViewMateriasPorCurso.findAll", query="SELECT v FROM ViewMateriasPorCurso v")
public class ViewMateriasPorCurso implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID_MAT_POR_CURSO")
	private String idMatPorCurso;
	private String annio;
	private String especialidad;
	@Column(name="ID_ANNIO")
	private BigInteger idAnnio;
	@Column(name="ID_CURSO")
	private BigInteger idCurso;
	@Column(name="ID_MAT")
	private BigInteger idMat;
	private String materia;
	private String nivel;
	@Column(name="PERIODO_ESCOLAR")
	private String periodoEscolar;
	private String seccion;
}