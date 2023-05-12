package com.tecnodestreza.siga.mappers;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.NotaParcial;
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

    public NotaParcialdtoToNotaParcialMapper(IMateriaService materiaService, IDocenteService docenteService, ICursoService cursoService, IAlumnoService alumnoService) {
        this.materiaService = materiaService;
        this.docenteService = docenteService;
        this.cursoService = cursoService;
        this.alumnoService = alumnoService;
    }

    @Override
    public NotaParcial apply(NotaParcialdto notadto) {
        Optional<Alumno> alumno=alumnoService.consultarAlumnoPorId(notadto.getAlumnoId());
        Optional<Docente> docente=docenteService.consultarDocentePorId(notadto.getDocenteId());
        NotaParcial nota=new NotaParcial();

        return nota;
    }
}
