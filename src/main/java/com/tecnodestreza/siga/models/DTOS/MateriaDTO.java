package com.tecnodestreza.siga.models.DTOS;

import com.tecnodestreza.siga.models.Materia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idMat;
	private String codigoMat;
	private String descripcionMat;
	private String nombreMat;
	private Long idAnnio;
	private String annio;
	private String nivel;
	private String especialidad;
	private String status;
	public MateriaDTO(Materia materia) {
		this.idMat = materia.getIdMat();
		this.codigoMat = materia.getCodigoMat();
		this.descripcionMat = materia.getDescripcionMat();
		this.nombreMat = materia.getNombreMat();
		this.idAnnio = materia.getAnnio().getIdAnnio();
		this.annio = materia.getAnnio().getAnnio();
		this.nivel = materia.getAnnio().getNivel();
		this.especialidad = materia.getAnnio().getEspecialidad();
		this.status=materia.getStatus();
	}
}
