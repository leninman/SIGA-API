/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.DTOS.AlumnoDTO;
import com.tecnodestreza.siga.models.mappers.AlumnoDtoToAlumnoMapper;
import com.tecnodestreza.siga.models.mappers.AlumnoDtoToRepresentanteMapper;
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
    public Responses guardarAlumno(AlumnoDTO alumnoDTO,Boolean modificar) {
        Representante rep1;
        Representante rep2;
        Responses resp = new Responses();
        Alumno alumno=new AlumnoDtoToAlumnoMapper().apply(alumnoDTO);
        try {
                alumno.setFechaCreacion(new Date());
                Annio annio = annioRepo.consultarAnnioByAnnioAndNivelAndEspecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(), alumnoDTO.getEspecialidad());
                AnnioEscolar annioEscolar = annioEscolarRepo.consultarAnnioEscolarVigente();
                Turno turno = turnoRepo.consultarTurnoByTurno(alumnoDTO.getTurno());
                Seccion seccion = seccionRepo.consultarSeccionBySeccion(alumnoDTO.getSeccion());
                Curso curso = cursoRepo.consultarCursoPorParametros(annio.getIdAnnio(), annioEscolar.getIdAnnioEsc(), seccion.getIdSec(), turno.getIdTurno());
                alumno.setCurso(curso);
                if (representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1()) == null) {
                    rep1 = new AlumnoDtoToRepresentanteMapper().obtenerRepresentante1(alumnoDTO);
                    representanteRepo.save(rep1);
                } else {
                    rep1 = representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1());
                }
                if (representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep2(), alumnoDTO.getNumDocRep2()) == null) {
                    rep2 = new AlumnoDtoToRepresentanteMapper().obtenerRepresentante2(alumnoDTO);
                    representanteRepo.save(rep2);
                } else {
                    rep2 = representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep2(), alumnoDTO.getNumDocRep2());
                }
                alumno.setRpr1(rep1);
                alumno.setRpr2(rep2);
                if (alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumno.getTipoDocAl(), alumno.getNumDocAl()) == null) {
                    Alumno alumnoguardado = alumnorepo.save(alumno);
                    resp.setAlumno(new AlumnoToAlumnoDtoMapper().apply(alumnoguardado));
                    resp.setResponseCode(Constantes.ALUMNO_REGISTRADO_CODE);
                    resp.setResponseDescription(Constantes.ALUMNO_REGISTRADO_DESC);
                } else {
                    if(!modificar) { //NO VA A MODIFICAR
                        resp.setResponseCode(Constantes.ALUMNO_EXISTE_CODE);
                        resp.setResponseDescription(Constantes.ALUMNO_EXISTE_DESC);
                    }else{ //VA A MODIFICAR
                        Alumno alumnoguardado=alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(alumno.getTipoDocAl(), alumno.getNumDocAl());
                        alumno.setIdAl(alumnoguardado.getIdAl());
                        alumno.setCurso(alumnoguardado.getCurso());
                        alumno.setRpr1(alumnoguardado.getRpr1());
                        alumno.setRpr2(alumnoguardado.getRpr2());
                        alumnoguardado=alumnorepo.save(alumno);
                        resp.setAlumno(new AlumnoToAlumnoDtoMapper().apply(alumnoguardado));
                        resp.setResponseCode(Constantes.ALUMNO_MODIFICADO_CODE);
                        resp.setResponseDescription(Constantes.ALUMNO_MODIFICADO_DESC);
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
    @Override
    public Responses modificarAlumno(AlumnoDTO alumnoDTO, Long idAlumno, Boolean modificar) {
        Responses resp=new Responses();
        Optional<Alumno> alumnoguardado=alumnorepo.findById(idAlumno);
        Alumno alumno=new AlumnoDtoToAlumnoMapper().apply(alumnoDTO);
        if(alumnoguardado.get()!=null){
            alumno.setIdAl(alumnoguardado.get().getIdAl());
            Annio annio = annioRepo.consultarAnnioByAnnioAndNivelAndEspecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(), alumnoDTO.getEspecialidad());
            AnnioEscolar annioEscolar = annioEscolarRepo.consultarAnnioEscolarVigente();
            Turno turno = turnoRepo.consultarTurnoByTurno(alumnoDTO.getTurno());
            Seccion seccion = seccionRepo.consultarSeccionBySeccion(alumnoDTO.getSeccion());
            Curso curso = cursoRepo.consultarCursoPorParametros(annio.getIdAnnio(), annioEscolar.getIdAnnioEsc(), seccion.getIdSec(), turno.getIdTurno());
            alumno.setCurso(curso);
            Representante representante1=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(),alumnoDTO.getNumDocRep1());
            Representante representante2=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep2(),alumnoDTO.getNumDocRep2());
            alumno.setCurso(alumnoguardado.get().getCurso());
            alumno.setRpr1(representante1);
            alumno.setRpr2(representante2);
            alumno.setFechaCreacion(alumnoguardado.get().getFechaCreacion());
            alumnoguardado=Optional.of(alumnorepo.save(alumno));
        }
        resp.setResponseCode(Constantes.ALUMNO_MODIFICADO_CODE);
        resp.setResponseDescription(Constantes.ALUMNO_MODIFICADO_DESC);
        resp.setAlumno(new AlumnoToAlumnoDtoMapper().apply(alumnoguardado.get()));
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
