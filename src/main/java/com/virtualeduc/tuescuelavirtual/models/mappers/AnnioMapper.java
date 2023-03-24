package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;

import java.util.function.Function;

public class AnnioMapper {


    public Annio AnnioDtoToAnnio(AnnioDTO annioDTO) {
        Annio annio=new Annio();
        annio.setIdAnnio(annioDTO.getIdAnnio());
        annio.setAnnio(annioDTO.getAnnio());
        annio.setNivel(annioDTO.getNivel());
        annio.setEspecialidad(annioDTO.getEspecialidad());
        return annio;
    }

    public AnnioDTO AnnioToAnnioDto(Annio annio) {
        AnnioDTO anniodto=new AnnioDTO();
        anniodto.setIdAnnio(annio.getIdAnnio());
        anniodto.setAnnio(annio.getAnnio());
        anniodto.setNivel(annio.getNivel());
        anniodto.setEspecialidad(annio.getEspecialidad());
        return anniodto;
    }
}
