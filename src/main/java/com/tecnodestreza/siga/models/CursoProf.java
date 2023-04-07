package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the `cursos_prof` database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cursos_prof")
public class CursoProf implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_CURSO_PROF")
	private Long idCursoProf;
	@Column(name="ID_CURSO")
	private Long idCurso;
	@Column(name="ID_MAT")
	private Long idMat;
	@Column(name="ID_PROF")
	private Long idProf;
}