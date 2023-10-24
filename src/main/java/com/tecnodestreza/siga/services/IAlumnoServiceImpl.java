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

import java.util.Date;
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
    @Autowired
    ICursoService cursoService;
    @Autowired
    IRepresentanteService representanteService;
    @Transactional
    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public Optional<Alumno> guardarAlumno(Alumno alumno,Long idAlumno) {
        Optional<Representante> optionalRepresentante;
        Optional<Curso> optionalCurso;
        Alumno alumnoguardado=new Alumno();
        try {

            if(idAlumno==null) { //GUARDAR
                optionalRepresentante=representanteRepo.findRepresentanteByTipoDocumentoAndNumeroDocumento(alumno.getRepresentante().getTipoDocumento(),alumno.getRepresentante().getNumeroDocumento());
                if (optionalRepresentante.isPresent()) {
                    alumno.getRepresentante().setId(optionalRepresentante.get().getId());
                }else{
                    alumno.getRepresentante().setId(representanteRepo.save(alumno.getRepresentante()).getId());
                }
                optionalCurso = cursoRepo.findCursoByAnnioAndSeccionAndTurnoAndNivelAndPeriodoAcademico(alumno.getCurso().getAnnio(),
                        alumno.getCurso().getSeccion(), alumno.getCurso().getTurno(),
                        alumno.getCurso().getNivel(), alumno.getCurso().getPeriodoAcademico());
                if (!optionalCurso.isPresent()) {
                    throw new RuntimeException("Curso no encontrado");
                } else {
                    alumno.setCurso(optionalCurso.get());
                }
                alumno.setFechaCreacion(new Date());
                if (alumno.getCondicion().equals("REGULAR")) {
                    alumno.setActivo(true);
                } else {
                    alumno.setActivo(false);
                }
            } else { //MODIFICAR
                Optional<Alumno> optionalAlumnoguardado = alumnorepo.findById(idAlumno);
                if (optionalAlumnoguardado.isPresent()) {
                    alumno.setId(optionalAlumnoguardado.get().getId());
                    alumno.setFechaCreacion(optionalAlumnoguardado.get().getFechaCreacion());
                    alumno.setActivo(optionalAlumnoguardado.get().getActivo());
                    Optional<Representante> optionalRepresentanteGuardado = representanteRepo.findById(optionalAlumnoguardado.get().getRepresentante().getId());
                    if (optionalRepresentanteGuardado.isPresent()&&optionalRepresentanteGuardado.get().getId()==alumno.getRepresentante().getId()) {
                        alumno.getRepresentante().setId(optionalRepresentanteGuardado.get().getId());
                        representanteRepo.save(alumno.getRepresentante());
                    }
                    optionalCurso = cursoRepo.findCursoByAnnioAndSeccionAndTurnoAndNivelAndPeriodoAcademico(alumno.getCurso().getAnnio(),
                            alumno.getCurso().getSeccion(), alumno.getCurso().getTurno(),
                            alumno.getCurso().getNivel(), alumno.getCurso().getPeriodoAcademico());
                    if (!optionalCurso.isPresent()) {
                        throw new RuntimeException("Curso no encontrado");
                    } else {
                        reordenarListas(optionalCurso.get().getId(),alumno);
                        alumno.setCurso(optionalCurso.get());
                    }

                }
            }
            alumnoguardado = alumnorepo.save(alumno);

        } catch (Exception e) {
            e.printStackTrace();
        }
            return Optional.of(alumnoguardado);
    }

    @Override
    public void desactivar(Long idAlumno,String condicion) {
        Optional<Alumno> alumno=alumnorepo.findById(idAlumno);
        if(alumno.isPresent()){
            alumno.get().setActivo(false);
            alumno.get().setCondicion(condicion.toUpperCase());
            alumnorepo.save(alumno.get());
            Optional<Representante> representante= Optional.ofNullable(alumno.get().getRepresentante());
            //Busca si el representante tiene algun otro alumno relacionado
            //Si no lo tiene desactiva el representante
            List<Alumno> alumnos=alumnorepo.consultarAlumnosPorRepresentante(representante.get().getId());
            if (alumnos.isEmpty()){
                representanteService.desactivar(representante.get().getId());
            }
        }
    }

    @Override
    public List<Alumno> alumnosPorCurso(Long idCurso) {
        return alumnorepo.findAlumnosByCursoId(idCurso);
    }

    @Override
    public void reordenarListas(Long idCursoNuevo, Alumno nuevoAlumno) {
        List<Alumno> alumnosCursoNuevo = alumnorepo.findAlumnosByCursoId(idCursoNuevo);
        List<Alumno> alumnnosCursoViejo = alumnorepo.findAlumnosByCursoId(nuevoAlumno.getCurso().getId());
        alumnnosCursoViejo.remove(nuevoAlumno);
        alumnosCursoNuevo.add(nuevoAlumno);
        cursoService.asignarNumeroDeLista(alumnosCursoNuevo);
        cursoService.asignarNumeroDeLista(alumnnosCursoViejo);
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

    @Override
    public Optional<Alumno> consultarAlumnoPorId(Long alumnoId) {
        return alumnorepo.findById(alumnoId);
    }
}
