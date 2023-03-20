package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;

import java.util.List;

public interface IProfesoresService {
	
	public List<ProfesorDTO> consultarProfesores();
	
	public Profesor consultarProfesorPorId(Long idProfesor);
	
	public Profesor consultarProfesorPorCedula(String tipoDocPrf,String numDocPrf);
	
	public Responses guardarProfesor(ProfesorDTO profesorDTO,boolean guardar);

	public Long[] consultarProfesoresPorIdCurso(Long idcurso);

}
