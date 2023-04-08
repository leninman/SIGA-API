/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;
import com.tecnodestreza.siga.models.*;

import com.tecnodestreza.siga.repo.*;
import com.tecnodestreza.siga.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@Service
public class IAlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepo alumnorepo;
    @Autowired
    IRepresentanteRepo representanteRepo;
    @Autowired
    ICursoRepo cursoRepo;
    @Transactional
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Alumno> crearAlumno(Alumno alumno, Boolean modificar) {
        Representante representante;
        Alumno alumnoguardado=new Alumno();
        try {
                if (representanteRepo.findRepresentanteByTipoDocumentoAndNumeroDocumento(alumno.getRepresentante().getTipoDocumento(),alumno.getRepresentante().getNumeroDocumento())==null) {
                    representanteRepo.save(alumno.getRepresentante());
                }
                if (alumnorepo.consultarAlumnoPorCedula(alumno.getTipoDocumento(), alumno.getNumeroDocumento()) == null) {
                     alumnoguardado = alumnorepo.save(alumno);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(alumnoguardado);
    }
    @Override
    public Optional<Alumno> modificarAlumno(Alumno alumno, Long idAlumno, Boolean modificar) {
        alumno.setId(idAlumno);
        return Optional.of(alumnorepo.save(alumno));
    }
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> consultarAlumnos() {
        return alumnorepo.consultarAlumnos();
    }
    @Override
    public Optional<Alumno> consultarAlumnoPorCedula(String tipoDoc, String numDoc) {
        return Optional.ofNullable(alumnorepo.consultarAlumnoPorCedula(tipoDoc, numDoc));
    }

    @Override
    public Optional<Alumno> consultarAlumnoPorId(Long idAlumno) {
        return alumnorepo.findById(idAlumno);
    }

}
