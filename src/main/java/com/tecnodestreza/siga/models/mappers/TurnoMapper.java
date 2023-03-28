package com.tecnodestreza.siga.models.mappers;

import com.tecnodestreza.siga.models.DTOS.TurnoDTO;
import com.tecnodestreza.siga.models.Turno;

public class TurnoMapper {


    public Turno TurnoDtoToTurno(TurnoDTO turnoDTO) {
        Turno turno=new Turno();
        turno.setIdTurno(turnoDTO.getIdTurno());
        turno.setTurno(turnoDTO.getTurno());
        return turno;
    }

    public TurnoDTO TurnoToTurnoDto(Turno turno) {
        TurnoDTO turnoDTO=new TurnoDTO();
        turnoDTO.setIdTurno(turno.getIdTurno());
        turnoDTO.setTurno(turno.getTurno());
        return turnoDTO;
    }
}
