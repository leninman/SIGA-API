/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.repo.*;
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
    public Optional<Alumno> guardarAlumno(Alumno alumno,Long idAlumno) {
        Optional<Representante> optionalRepresentante;
        Optional<Curso> optionalCurso;
        Alumno alumnoguardado=new Alumno();
        try {
            optionalRepresentante=representanteRepo.findRepresentanteByTipoDocumentoAndNumeroDocumento(alumno.getRepresentante().getTipoDocumento(),alumno.getRepresentante().getNumeroDocumento());
            if (!optionalRepresentante.isPresent()) {
                representanteRepo.save(alumno.getRepresentante());
            }else{
                alumno.getRepresentante().setId(optionalRepresentante.get().getId());
            }
            optionalCurso=cursoRepo.consultarCursosPorParametros(alumno.getCurso().getAnnio(),
                    alumno.getCurso().getSeccion(),alumno.getCurso().getPeriodoAcademico(),
                    alumno.getCurso().getTurno(),alumno.getCurso().getNivel(),
                    alumno.getCurso().getEspecialidad());
            alumno.getCurso().setId(optionalCurso.get().getId());
            if(idAlumno!=null){  //MODIFICAR
                Optional<Alumno> optionalAlumnoguardado=alumnorepo.findById(idAlumno);
                alumno.setId(idAlumno);
                alumno.setFechaCreacion(optionalAlumnoguardado.get().getFechaCreacion());
            }
            alumnoguardado=alumnorepo.save(alumno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(alumnoguardado);
    }
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> consultarAlumnos() {
        return alumnorepo.consultarAlumnos();
    }
    @Override
    public Optional<Alumno> consultarAlumnoPorCedula(String tipoDoc, String numDoc) {
        return alumnorepo.findAlumnoByTipoDocumentoAndNumeroDocumento(tipoDoc, numDoc);
    }
}
