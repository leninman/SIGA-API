/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@Service
public class ICursoServiceImpl implements ICursoService {

    private final ICursoRepo cursorepo;
    private final ICursoDocenteRepo cursoDocenteRepo;


    @Override
    public Optional<Curso> consultarCursoPorParametros(String annio, String seccion, String turno, String nivel, String periodoAcademico) {
        return cursorepo.consultarCursosPorParametros(annio,seccion,turno,nivel,periodoAcademico);
    }

    @Override
    public Optional<Curso> consultarCursoPorId(Long cursoId) {
        return cursorepo.findById(cursoId);
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
}
