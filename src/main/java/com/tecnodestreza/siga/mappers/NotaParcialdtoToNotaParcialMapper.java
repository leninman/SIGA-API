package com.tecnodestreza.siga.mappers;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.NotaParcialdto;
import com.tecnodestreza.siga.services.IAlumnoService;
import com.tecnodestreza.siga.services.ICursoService;
import com.tecnodestreza.siga.services.IDocenteService;
import com.tecnodestreza.siga.services.IMateriaService;

import java.util.Optional;
import java.util.function.Function;

public class NotaParcialdtoToNotaParcialMapper implements Function<NotaParcialdto, NotaParcial> {
    private final IMateriaService materiaService;
    private final IDocenteService docenteService;
    private final ICursoService cursoService;
    private final IAlumnoService alumnoService;
    private NotaParcial nota;

    public NotaParcialdtoToNotaParcialMapper(IMateriaService materiaService, IDocenteService docenteService, ICursoService cursoService, IAlumnoService alumnoService) {
        this.materiaService = materiaService;
        this.docenteService = docenteService;
        this.cursoService = cursoService;
        this.alumnoService = alumnoService;
    }

    @Override
    public NotaParcial apply(NotaParcialdto notadto) {

        try {
            Optional<Curso> curso = cursoService.consultarCursoPorId(notadto.getCursoId());
            Optional<Alumno> alumno = alumnoService.consultarAlumnoPorId(notadto.getAlumnoId());
            Optional<Docente> docente = docenteService.consultarDocentePorId(notadto.getDocenteId());
            Optional<Materia> materia = materiaService.consultarMateriaPorId(notadto.getMateriaId());

            if (alumno.isPresent() && docente.isPresent() && materia.isPresent() && curso.isPresent()) {
                nota = new NotaParcial(null, alumno.get(), docente.get(), curso.get(), materia.get(), notadto.getLapso(), notadto.getNota(), null);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return nota;
    }
}
