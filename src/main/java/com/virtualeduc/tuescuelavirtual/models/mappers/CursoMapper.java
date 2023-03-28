package com.virtualeduc.tuescuelavirtual.models.mappers;

import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;

import java.util.Optional;



public class CursoMapper {

    public Curso CursoDtoToCurso(CursoDTO cursoDTO) {
        Curso curso=new Curso();
       // curso.setAnnio();
        /*curso.setAnnio(annio;
        this.annioEscolar = annioEscolar;
        this.seccion = seccion;
        this.turno = turno;*/
        return curso;

    }

    public Optional<CursoDTO> CursoToCursoDto(Curso curso) {
        Optional<CursoDTO> cursoDTO= Optional.of(new CursoDTO());
        cursoDTO.get().setIdCurso(curso.getIdCurso());
        cursoDTO.get().setAnnio(curso.getAnnio().getAnnio());
        cursoDTO.get().setIdSec(curso.getSeccion().getIdSec());
        cursoDTO.get().setIdAnnioEsc(curso.getAnnioEscolar().getIdAnnioEsc());
        cursoDTO.get().setNivel(curso.getAnnio().getNivel());
        cursoDTO.get().setEspecialidad(curso.getAnnio().getEspecialidad());
        cursoDTO.get().setIdTurno(curso.getTurno().getIdTurno());
        cursoDTO.get().setAnnio(curso.getAnnio().getAnnio());
        cursoDTO.get().setIntAnnioEsc(curso.getAnnioEscolar().getIntAnnioEsc());
        cursoDTO.get().setSeccion(curso.getSeccion().getSeccion());
        cursoDTO.get().setTurno(curso.getTurno().getTurno());
        return cursoDTO;
    }
}
