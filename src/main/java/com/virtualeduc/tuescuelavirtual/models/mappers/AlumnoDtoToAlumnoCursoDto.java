package com.virtualeduc.tuescuelavirtual.models.mappers;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import java.util.function.Function;
public class AlumnoDtoToAlumnoCursoDto implements Function<AlumnoDTO, AlumnoCursoDTO> {
    @Override
    public AlumnoCursoDTO apply(AlumnoDTO alumnoDTO) {
        AlumnoCursoDTO alumnoCursoDTO=new AlumnoCursoDTO();
        alumnoCursoDTO.setIdAl(alumnoDTO.getIdAl());
        alumnoCursoDTO.setTipoDocAl(alumnoDTO.getTipoDocAl());
        alumnoCursoDTO.setNumDocAl(alumnoDTO.getNumDocAl());
        alumnoCursoDTO.setPrimNombAl(alumnoDTO.getPrimNombAl());
        alumnoCursoDTO.setSegNombAl(alumnoDTO.getSegNombAl());
        alumnoCursoDTO.setPrimApellAl(alumnoDTO.getPrimApellAl());
        alumnoCursoDTO.setSegApellAl(alumnoDTO.getSegApellAl());
        alumnoCursoDTO.setAnnio(alumnoDTO.getAnnio());
        alumnoCursoDTO.setSeccion(alumnoDTO.getSeccion());
        return alumnoCursoDTO;
    }
}
