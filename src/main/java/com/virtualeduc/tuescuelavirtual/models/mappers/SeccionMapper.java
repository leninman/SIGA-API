package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import com.virtualeduc.tuescuelavirtual.models.Turno;

public class SeccionMapper {


    public Seccion SeccionDtoToSeccion(SeccionDTO seccionDTO) {
        Seccion seccion=new Seccion();
        seccion.setIdSec(seccionDTO.getIdSec());
        seccion.setSeccion(seccionDTO.getSeccion());
        return seccion;

    }

    public SeccionDTO SeccionToSeccionDto(Seccion seccion) {
        SeccionDTO seccionDTO=new SeccionDTO();
        seccionDTO.setIdSec(seccion.getIdSec());
        seccionDTO.setSeccion(seccion.getSeccion());
        return  seccionDTO;

    }


}
