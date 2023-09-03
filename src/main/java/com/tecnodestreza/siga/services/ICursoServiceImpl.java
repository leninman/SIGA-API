/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;
import com.tecnodestreza.siga.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@Service
public class ICursoServiceImpl implements ICursoService {

    private final ICursoRepo cursorepo;
    private final ICursoDocenteRepo cursoDocenteRepo;

    private final IAlumnoRepo alumnoRepo;
    private final IDocenteRepo docenteRepo;


    @Override
    public Optional<Curso> consultarCursoPorParametros(String annio, String seccion, String turno, String nivel, String periodoAcademico) {
        return cursorepo.findCursoByAnnioAndSeccionAndTurnoAndNivelAndPeriodoAcademico(annio,seccion,turno,nivel,periodoAcademico);
    }

    @Override
    public Optional<Curso> consultarCursoPorId(Long cursoId) {
        Optional<Curso> curso=cursorepo.consultarCursoPorId(cursoId);
        return curso;
    }

    @Override
    public Optional<Curso> crear(Curso curso) {
        return Optional.of(cursorepo.save(curso));
    }

    @Override
    public List<Curso> listarcursos() {
        return cursorepo.findAll();
    }

    @Override
    public Optional<CursoDocente> asignarcursos(CursoDocente cursoDocente) {
        return Optional.of(cursoDocenteRepo.save(cursoDocente));
    }

    @Override
    public Curso cargarcurso(String[] cedulas, Long idcurso) {
        Optional<Curso> curso=cursorepo.findById(idcurso);
        List<Alumno> alumnos=Arrays.stream(cedulas).map(cedula ->
                (alumnoRepo.findAlumnoByTipoDocumentoAndNumeroDocumento(cedula.substring(0,1),cedula.substring(1))).get()).collect(Collectors.toList());
        for (Alumno alumno:alumnos){
            alumno.setCurso(curso.get());
            alumnoRepo.save(alumno);
        }
        return curso.get();
    }

    @Override
    public List<CursoDocente> consultarCursosPorDocente(PersonaDocumentodto cedula) {
        Optional<Docente> docente=docenteRepo.findDocenteByTipoDocumentoAndNumeroDocumento(cedula.getTipoDocumento(),cedula.getNumeroDocumento());
        Long idDocente=docente.get().getId();
        return cursoDocenteRepo.consultarCursosPorDocente(idDocente);
    }
}
