package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.DTOS.ProfesorDTO;
import com.tecnodestreza.siga.models.Profesor;
import com.tecnodestreza.siga.models.Responses;

import java.util.List;

public interface IProfesoresService {
	
	public List<ProfesorDTO> consultarProfesores();
	
	public Profesor consultarProfesorPorId(Long idProfesor);
	
	public Profesor consultarProfesorPorCedula(String tipoDocPrf,String numDocPrf);
	
	public Responses guardarProfesor(ProfesorDTO profesorDTO, boolean guardar);

	public Long[] consultarProfesoresPorIdCurso(Long idcurso);

}
