package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.DTOS.MateriaDTO;
import com.tecnodestreza.siga.models.Materia;
import com.tecnodestreza.siga.models.Responses;

import java.util.List;

public interface IMateriaService {
	
	public Responses guardarMateria(Materia materia, boolean guardar);
	
    public List<MateriaDTO> listaMaterias();
    
    public MateriaDTO consultarMateriaPorId(Long idMateria);
    
    public MateriaDTO consultarMateriaPorCodigo(String codigoMateria);
    
    public Responses desactivarMateria(Long idMat);
    
    public List<String> nombresmaterias();
    
    public Long consultarIdMaterias(String materia,String annio,String nivel,String especialidad);
    
    
    
    

}
