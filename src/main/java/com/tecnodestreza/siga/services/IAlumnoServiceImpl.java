/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.DTOS.AlumnoDTO;
import com.tecnodestreza.siga.models.mappers.AlumnoToAlumnoDtoMapper;
import com.tecnodestreza.siga.repo.*;
import com.tecnodestreza.siga.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public Responses guardaAlumno(Alumno alumno) {
        Representante rep1;
        Representante rep2;
        Responses resp = new Responses();
        try {
            alumno.setFechaCreacion(new Date());
            if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumno.getRpr1().getTipoDocRpr(), alumno.getRpr1().getNumDocRpr())==null){
                rep1=representanteRepo.save(alumno.getRpr1());
            }else{
                rep1=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumno.getRpr1().getTipoDocRpr(), alumno.getRpr1().getNumDocRpr());
            }
            if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumno.getRpr2().getTipoDocRpr(), alumno.getRpr2().getNumDocRpr())==null){
                rep2=representanteRepo.save(alumno.getRpr2());
            }else{
                rep2=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumno.getRpr2().getTipoDocRpr(), alumno.getRpr2().getNumDocRpr());
            }
            alumno.setRpr1(rep1);
            alumno.setRpr2(rep2);
            Annio annio=annioRepo.consultarAnnioByAnnioAndNivelAndEspecialidad(alumno.getCurso().getAnnio().getAnnio(),alumno.getCurso().getAnnio().getNivel(),alumno.getCurso().getAnnio().getEspecialidad());
            AnnioEscolar annioEscolar=annioEscolarRepo.consultarAnnioEscolarVigente();
            Turno turno=turnoRepo.consultarTurnoByTurno(alumno.getCurso().getTurno().getTurno());
            Seccion seccion=seccionRepo.consultarSeccionBySeccion(alumno.getCurso().getSeccion().getSeccion());
            Curso curso=cursoRepo.consultarCursoPorParametros(annio.getIdAnnio(),annioEscolar.getIdAnnioEsc(),seccion.getIdSec(),turno.getIdTurno());
            alumno.setCurso(curso);
            if (alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumno.getTipoDocAl(), alumno.getNumDocAl()) == null) {
                resp.setResponseCode(Constantes.ALUMNO_REGISTRADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_REGISTRADO_DESC);
            }else {
                alumno.setIdAl(alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumno.getTipoDocAl(), alumno.getNumDocAl()).getIdAl());
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
        return  alumnorepo.findById(id).orElse(null);
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
        return alumnorepo.findAlumnoByIdCurso(idcurso);
    }
    @Override
    public String consultarCedulasDeAlumnos(String tipoDocAl, String numDocAl) {
        return new Alumno().getTipoDocAl().concat(alumnorepo.findCedulasAlumnos(tipoDocAl, numDocAl).getNumDocAl());
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
