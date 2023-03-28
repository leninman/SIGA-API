/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.*;
import com.virtualeduc.tuescuelavirtual.models.DTOS.*;
import com.virtualeduc.tuescuelavirtual.models.mappers.AlumnoDtoToAlumnoMapper;
import com.virtualeduc.tuescuelavirtual.models.mappers.AlumnoDtoToRepresentanteMapper;
import com.virtualeduc.tuescuelavirtual.models.mappers.AlumnoToAlumnoDtoMapper;
import com.virtualeduc.tuescuelavirtual.models.mappers.CursoMapper;
import com.virtualeduc.tuescuelavirtual.repo.*;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class IAlumnoServiceImpl implements IAlumnoService {
    @Autowired
    IAlumnoRepo alumnorepo;
    @Autowired
    IRepresentanteRepo representanteRepo;
    @Autowired
    ICursoRepo cursoRepo;
    @Autowired
    IAnnioRepo annioRepo;
    @Autowired
    IAnnioEscolarRepo annioEscolarRepo;
    @Autowired
    ITurnoRepo turnoRepo;
    @Autowired
    ISeccionRepo seccionRepo;
    @Override
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Responses guardaAlumno(AlumnoDTO alumnoDTO) {
        Representante rep1;
        Representante rep2;
        Responses resp = new Responses();
        Alumno alumno = new AlumnoDtoToAlumnoMapper().apply(alumnoDTO);
        try {
            alumno.setFechaCreacion(new Date());
            if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1())==null){
                rep1=representanteRepo.save(new AlumnoDtoToRepresentanteMapper().apply(alumnoDTO));
            }else{
                rep1=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1());
            }
            if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep2(), alumnoDTO.getNumDocRep2())==null){
                rep2=representanteRepo.save(new AlumnoDtoToRepresentanteMapper().apply(alumnoDTO));
            }else{
                rep2=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1());
            }
            alumno.setRpr1(rep1);
            alumno.setRpr2(rep2);
            Annio annio=annioRepo.consultarAnnioByAnnioAndNivelAndEspecialidad(alumnoDTO.getAnnio(),alumnoDTO.getNivel(),alumnoDTO.getEspecialidad());
            AnnioEscolar annioEscolar=annioEscolarRepo.consultarAnnioEscolarVigente();
            Turno turno=turnoRepo.consultarTurnoByTurno(alumnoDTO.getTurno());
            Seccion seccion=seccionRepo.consultarSeccionBySeccion(alumnoDTO.getSeccion());
            Curso curso=cursoRepo.consultarCursoPorParametros(annio.getIdAnnio(),annioEscolar.getIdAnnioEsc(),seccion.getIdSec(),turno.getIdTurno());
            alumno.setCurso(curso);
            if (alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumnoDTO.getTipoDocAl(), alumnoDTO.getNumDocAl()) == null) {
                resp.setResponseCode(Constantes.ALUMNO_REGISTRADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_REGISTRADO_DESC);
            }else {
                alumno.setIdAl(alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumnoDTO.getTipoDocAl(), alumnoDTO.getNumDocAl()).getIdAl());
                resp.setResponseCode(Constantes.ALUMNO_MODIFICADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_MODIFICADO_DESC);
            }
            Alumno alumnoguardado = alumnorepo.save(alumno);
            resp.setAlumno(new AlumnoToAlumnoDtoMapper().apply(alumnoguardado));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    @Override
    @Transactional(readOnly = true)
    public List<AlumnoDTO> consultarAlumnos() {
        List<Alumno> alumnos = alumnorepo.findAll();
        return alumnos.stream().map(Alumno ->
                    new AlumnoToAlumnoDtoMapper().apply(Alumno)).collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public Alumno consultarAlumnoPorId(Long id) {
        Alumno alumno = null;
        try {
            alumno = alumnorepo.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumno;
    }
    @Override
    public Alumno consultarAlumnoPorCedula(String tipoDoc, String numDoc) {
        return alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(tipoDoc, numDoc);
    }
    @Override
    public List<AlumnoDTO> consultarTodosLosAlumnos() {
        return alumnorepo.findAll().stream().map(Alumno->new AlumnoToAlumnoDtoMapper().apply(Alumno)).collect(Collectors.toList());
    }
    @Override
    public Long[] consultarIdAlumnoPorIdCurso(Long idcurso) {
        Long[] listaIdAlumnos = null;
        listaIdAlumnos = alumnorepo.findAlumnoByIdCurso(idcurso);
        return listaIdAlumnos;
    }
    @Override
    public String consultarCedulasDeAlumnos(String tipoDocAl, String numDocAl) {
        Alumno alumno = new Alumno();
        alumno = alumnorepo.findCedulasAlumnos(tipoDocAl, numDocAl);
        String cedula = alumno.getTipoDocAl().concat(alumno.getNumDocAl());
        return cedula;
    }
    @Override
    public Responses consultarAlumnosPorCurso(Long idcurso) {
        Responses resp = new Responses();
        List<AlumnoDTO> alumnosdto = new ArrayList<>();
        List<Alumno> alumnos = new ArrayList<>();
        alumnos = alumnorepo.findAlumnosByCurso(idcurso);
        if (alumnos != null) {
            alumnosdto=alumnos.stream().map(Alumno->new AlumnoToAlumnoDtoMapper().apply(Alumno)).collect(Collectors.toList());
            resp.setListadeAlumnos(alumnosdto);

        } else {
            resp.setResponseCode(Constantes.CURSO_SIN_INSCRITOS_CODE);
            resp.setResponseDescription(Constantes.CURSO_SIN_INSCRITOS_DESC);
        }
        return resp;
    }
    @Override
    public Responses consultarAlumnosPorCursoYmateria(Long idcurso, Long idmateria) {
        Responses resp = new Responses();
        List<AlumnoDTO> alumnosdto = new ArrayList<>();
        List<Alumno> alumnos = new ArrayList<>();
        alumnos = alumnorepo.findAlumnosByCursoAndMateria(idcurso, idmateria);
        if (alumnos != null) {
            alumnosdto=alumnos.stream().map(Alumno->new AlumnoToAlumnoDtoMapper().apply(Alumno)).collect(Collectors.toList());
            resp.setListadeAlumnos(alumnosdto);
        } else {
            resp.setResponseCode(Constantes.CURSO_SIN_INSCRITOS_CODE);
            resp.setResponseDescription(Constantes.CURSO_SIN_INSCRITOS_DESC);
        }
        return resp;
    }
}
