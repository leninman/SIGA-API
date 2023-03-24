package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;

public class AnnioEscolarMapper {
    public AnnioEscolar AnnioEscolarDtoToAnnioEscolar(AnnioEscolarDTO annioEscolarDTO) {
        AnnioEscolar annioEscolar=new AnnioEscolar();
        annioEscolar.setIdAnnioEsc(annioEscolarDTO.getIdAnnioEsc());
        annioEscolar.setIntAnnioEsc(annioEscolarDTO.getIntAnnioEsc());
        annioEscolar.setFechaI(annioEscolarDTO.getFechaI());
        annioEscolar.setFechaF(annioEscolarDTO.getFechaF());
        annioEscolar.setStatus(annioEscolarDTO.getStatus());
        return annioEscolar;
    }

    public AnnioEscolarDTO AnnioEscolarToAnnioEscolarDto(AnnioEscolar annioescolar) {
        AnnioEscolarDTO annioEscolarDTO=new AnnioEscolarDTO();
        annioEscolarDTO.setIdAnnioEsc(annioescolar.getIdAnnioEsc());
        annioEscolarDTO.setIntAnnioEsc(annioescolar.getIntAnnioEsc());
        annioEscolarDTO.setFechaI(annioescolar.getFechaI());
        annioEscolarDTO.setFechaF(annioescolar.getFechaF());
        annioEscolarDTO.setStatus(annioescolar.getStatus());
        return annioEscolarDTO;
    }
}
