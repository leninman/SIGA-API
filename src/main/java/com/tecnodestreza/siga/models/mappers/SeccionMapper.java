package com.tecnodestreza.siga.models.mappers;

import com.tecnodestreza.siga.models.DTOS.SeccionDTO;
import com.tecnodestreza.siga.models.Seccion;

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
