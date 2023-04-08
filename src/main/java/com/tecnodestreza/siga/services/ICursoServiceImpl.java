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

import java.util.Optional;

/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@Service
public class ICursoServiceImpl implements ICursoService {

    private final ICursoRepo cursorepo;

    @Override
    public Optional<Curso> consultarCursoPorId(Long idcurso) {
        return cursorepo.findById(idcurso);
    }

    @Override
    public Optional<Curso> crearCurso(Curso curso, boolean guardarCurso) {
        return Optional.of(cursorepo.save(curso));
    }
}
