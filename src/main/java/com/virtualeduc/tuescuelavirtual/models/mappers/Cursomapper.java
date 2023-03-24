package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.Seccion;

import java.util.Optional;

public class Cursomapper {
    public Curso CursoDtoToCurso(CursoDTO cursoDTO) {
        Curso curso=new Curso();
        /*curso.setAnnio(annio;
        this.annioEscolar = annioEscolar;
        this.seccion = seccion;
        this.turno = turno;*/
        return curso;

    }

    public CursoDTO CursoToCursoDto(Optional<Curso> curso) {
        CursoDTO cursoDTO=new CursoDTO();
        /*this.idCurso=curso.getIdCurso();
        this.idAnnio=curso.getAnnio().getIdAnnio();
        this.idSec = curso.getSeccion().getIdSec();
        this.idAnnioEsc=curso.getAnnioEscolar().getIdAnnioEsc();
        this.nivel=curso.getAnnio().getNivel();
        this.especialidad=curso.getAnnio().getEspecialidad();
        this.idTurno=curso.getTurno().getIdTurno();
        this.annio=curso.getAnnio().getAnnio();
        this.intAnnioEsc=curso.getAnnioEscolar().getIntAnnioEsc();
        this.seccion=curso.getSeccion().getSeccion();
        this.turno=curso.getTurno().getTurno();*/
        return cursoDTO;

    }
}
