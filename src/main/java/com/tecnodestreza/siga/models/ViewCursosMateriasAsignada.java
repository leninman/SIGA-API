package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * The persistent class for the view_cursos_materias_asignadas database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="view_cursos_materias_asignadas")
@NamedQuery(name="ViewCursosMateriasAsignada.findAll", query="SELECT v FROM ViewCursosMateriasAsignada v")
public class ViewCursosMateriasAsignada implements Serializable {
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
	@Column(name="ID_PRF")
	private BigInteger idPrf;
	@Column(name="NUM_DOC_PRF")
	private String numDocPrf;
	@Column(name="PERIODO_ESCOLAR")
	private String periodoEscolar;
	@Column(name="PRIM_APELL_PRF")
	private String primApellPrf;
	@Column(name="PRIM_NOMB_PRF")
	private String primNombPrf;
	private String seccion;
	@Column(name="SEG_APELL_PRF")
	private String segApellPrf;
	@Column(name="SEG_NOMB_PRF")
	private String segNombPrf;
	@Column(name="TIPO_DOC_PRF")
	private String tipoDocPrf;

}