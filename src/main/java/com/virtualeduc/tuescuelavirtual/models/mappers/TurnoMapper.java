package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
import com.virtualeduc.tuescuelavirtual.models.Turno;

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
