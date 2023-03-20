package com.virtualeduc.tuescuelavirtual.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;


/**
 * The persistent class for the `materias-prof` database table.
 * 
 */
@Entity
@Table(name="materias-prof")

public class MateriaProf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_MAT_PROF")
	private Long idMatProf;

	@Column(name="ID_MAT")
	private BigInteger idMat;

	@Column(name="ID_PROF")
	private BigInteger idProf;
	
	
	

	public MateriaProf() {
	}

	

	public MateriaProf(Long idMatProf, BigInteger idMat, BigInteger idProf) {
		super();
		this.idMatProf = idMatProf;
		this.idMat = idMat;
		this.idProf = idProf;
	}



	public Long getIdMatProf() {
		return idMatProf;
	}



	public void setIdMatProf(Long idMatProf) {
		this.idMatProf = idMatProf;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public BigInteger getIdMat() {
		return this.idMat;
	}

	public void setIdMat(BigInteger idMat) {
		this.idMat = idMat;
	}

	public BigInteger getIdProf() {
		return this.idProf;
	}

	public void setIdProf(BigInteger idProf) {
		this.idProf = idProf;
	}

}