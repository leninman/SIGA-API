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
    public Optional<Curso> consultarCursoPorParametros(String periodo, String annio, String seccion, String turno, String nivel, String especialidad, String periodoAcademico) {
        return cursorepo.consultarCursosPorParametros(annio,seccion,periodoAcademico,turno,nivel,especialidad);
    }

    @Override
    public Optional<Curso> crear(Curso curso) {
        return Optional.of(cursorepo.save(curso));
    }
}
