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
import com.virtualeduc.tuescuelavirtual.models.mappers.Cursomapper;
import com.virtualeduc.tuescuelavirtual.repo.IAlumnoRepo;
import com.virtualeduc.tuescuelavirtual.repo.ICursoRepo;
import com.virtualeduc.tuescuelavirtual.repo.IRepresentanteRepo;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Personal
 */
@Service
public class IAlumnoServiceImpl implements IAlumnoService {



    @Autowired
    IAlumnoRepo alumnorepo;
    @Autowired
    IRepresentanteRepo representanteRepo;
    @Autowired
    ICursoRepo cursoRepo;



    ;

	AlumnoDTO alumnoDTO;

    Alumno alumnoguardado;

    Alumno alumnoactualizado;

    String cedula;
    Representante rep1;
    Representante rep2;


    @Override
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Responses guardaAlumno(AlumnoDTO alumnoDTO) {
        String tipoDocRpr;
        String numDocRpr;
        Curso curso = new Curso();
        Responses resp = new Responses();
        Alumno alumno = new AlumnoDtoToAlumnoMapper().apply(alumnoDTO);
        try {
            Alumno alumnoconsultado = this.consultarAlumnoPorCedula(alumno.getTipoDocAl(), alumno.getNumDocAl());
            if (alumnoconsultado == null){
                alumno.setFechaCreacion(new Date());
                /*AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(),alumnoDTO.getEspecialidad());
                AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolar();
                SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());
                TurnoDTO turnoDTO = cursoservice.consultarTurnoPorTurno(alumnoDTO.getTurno());
                CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(),annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());
                Annio annio = new Annio(annioDTO);
                AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);
                Seccion seccion = new Seccion(seccionDTO);
                Turno turno = new Turno(turnoDTO);
                curso.setIdAnnio(annio);
                curso.setIdAnnioEsc(annioescolar);
                curso.setIdSec(seccion);
                curso.setIdTurno(turno);
                curso.setIdCurso(cursoDTO.getIdCurso());
                alumno.setIdCurso(curso);
                tipoDocRpr = alumnoDTO.getTipoDocRep1();
                numDocRpr = alumnoDTO.getNumDocRep1();
                Representante rep1 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
                if (rep1 == null) {
                    Representante rep = new Representante();
                    rep1 = rep.setRepresentante1(alumnoDTO);
                    alumno.setIdRpr1(representanteservice.guardarRepresentante(rep1));
                } else {
                    alumno.setIdRpr1(rep1);
                }
                if (alumnoDTO.getTipoDocRep2() != null && !alumnoDTO.getNumDocRep2().equals("")) {
                    tipoDocRpr = alumnoDTO.getTipoDocRep2();
                    numDocRpr = alumnoDTO.getNumDocRep2();
                    Representante rep2 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
                    if (rep2 == null) {
                        Representante rep = new Representante();
                        rep2 = rep.setRepresentante2(alumnoDTO);
                        alumno.setIdRpr2(representanteservice.guardarRepresentante(rep2));
                    } else {
                        alumno.setIdRpr2(rep2);
                    }

                } else {
                    alumno.setIdRpr2(rep1);
                }*/
                if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1())==null){
                    Representante representante=new AlumnoDtoToRepresentanteMapper().apply(alumnoDTO);
                    rep1=representanteRepo.save(representante);
                }else{
                    rep1=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1());
                }
                if(representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep2(), alumnoDTO.getNumDocRep2())==null){
                    Representante representante=new AlumnoDtoToRepresentanteMapper().apply(alumnoDTO);
                    rep2=representanteRepo.save(representante);
                }else{
                    rep2=representanteRepo.findRepresentanteByTipoDocRprAndNumDocRpr(alumnoDTO.getTipoDocRep1(), alumnoDTO.getNumDocRep1());
                }
                alumno.setRpr1(rep1);
                alumno.setRpr2(rep2);


                alumnoguardado = alumnorepo.save(alumno);
                resp.setResponseCode(Constantes.ALUMNO_REGISTRADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_REGISTRADO_DESC);
                resp.setResponseCode(Constantes.ALUMNO_EXISTE_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_EXISTE_DESC);
                alumnoDTO = new AlumnoDTO(alumnoconsultado);
                resp.setAlumno(alumnoDTO);

            } else {
                resp.setResponseCode(Constantes.ALUMNO_MODIFICADO_CODE);
                resp.setResponseDescription(Constantes.ALUMNO_MODIFICADO_DESC);
                this.alumnoactualizado = alumnorepo.save(alumno);
                this.alumnoDTO = new AlumnoDTO(alumnoactualizado);
                resp.setAlumno(this.alumnoDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;

    }

    /*public Numerosdelista generarNumeroDeListaAlumno(Long idAlumno,Long idCurso){

        Numerosdelista numerosdelistaAsignar = new Numerosdelista();

        Long numeroAsignado;

        Numerosdelista numerodelista=numerodelistaRepo.consultarNumeroListaAlumno(idAlumno,idCurso);



        if(numerodelista==null){

            Long numeroMaximoLista=numerodelistaRepo.consultarNumeroListaMayor(idCurso);

            if(numeroMaximoLista==null){
                numeroAsignado= Long.valueOf(1);
            }else {
                numeroAsignado = numeroMaximoLista + 1;
            }

            numerosdelistaAsignar.setIdAlumno(idAlumno);

            numerosdelistaAsignar.setIdCurso(idCurso);

            numerosdelistaAsignar.setNroLista(numeroAsignado);

            numerosdelistaAsignar = numerodelistaRepo.save(numerosdelistaAsignar);


        }

        return numerosdelistaAsignar;

    }*/

    /**
     *
     * @return
     */
   /* @Override
    @Transactional(readOnly = true)
    public List<AlumnoCursoDTO> consultarAlumnos() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.

        List<Alumno> alumnos = alumnorepo.findListAlumnos();

        List<AlumnoCursoDTO> alumnosCursoDTO = new ArrayList<AlumnoCursoDTO>();

        for (int i = 0; i < alumnos.size(); i++) {

            Alumno al = new Alumno();

            al = alumnos.get(i);

            AlumnoCursoDTO al1 = new AlumnoCursoDTO(al);

            alumnosCursoDTO.add(al1);

        }

        return alumnosCursoDTO;

    }*/
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
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
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
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
        return alumnorepo.findAlumnoByTipoDocAlAndNumDocAl(tipoDoc, numDoc);
    }

    @Override
    public List<AlumnoDTO> consultarTodosLosAlumnos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<AlumnoDTO> alumnosDTO = new ArrayList<AlumnoDTO>();

        List<Alumno> alumnos = alumnorepo.findAll();

        for (int i = 0; i < alumnos.size(); i++) {

            Alumno al = new Alumno();

            al = alumnos.get(i);

            AlumnoDTO al1 = new AlumnoDTO(al);

            alumnosDTO.add(al1);

        }

        return alumnosDTO;
    }

    @Override
    public Long[] consultarIdAlumnoPorIdCurso(Long idcurso) {
        // TODO Auto-generated method stub
        Long[] listaIdAlumnos = null;

        listaIdAlumnos = alumnorepo.findAlumnoByIdCurso(idcurso);

        return listaIdAlumnos;
    }

    @Override
    public String consultarCedulasDeAlumnos(String tipoDocAl, String numDocAl) {
        // TODO Auto-generated method stub

        Alumno alumno = new Alumno();
        alumno = alumnorepo.findCedulasAlumnos(tipoDocAl, numDocAl);

        cedula = alumno.getTipoDocAl().concat(alumno.getNumDocAl());

        return cedula;
    }

    @Override
    public Responses consultarAlumnosPorCurso(Long idcurso) {
        // TODO Auto-generated method stub

        Responses resp = new Responses();

        List<AlumnoDTO> alumnosdto = new ArrayList<>();

        List<Alumno> alumnos = new ArrayList<>();

        alumnos = alumnorepo.findAlumnosByCurso(idcurso);

        if (alumnos != null) {

            for (int i = 0; i < alumnos.size(); i++) {
                Alumno alumno = new Alumno();
                alumno = alumnos.get(i);
                AlumnoDTO alumnodto = new AlumnoDTO(alumno);
                alumnosdto.add(alumnodto);
            }

            resp.setListadeAlumnos(alumnosdto);

        } else {
            resp.setResponseCode(Constantes.CURSO_SIN_INSCRITOS_CODE);
            resp.setResponseDescription(Constantes.CURSO_SIN_INSCRITOS_DESC);
        }

        return resp;
    }

    @Override
    public void ActualizarIdAlumno(Long idCurso, String[] Cedulas) {
        // TODO Auto-generated method stub
        Curso curso = new Curso();

        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO = new Cursomapper().CursoToCursoDto(cursoRepo.findById(idCurso));

    }


    /*
	 * @Override public Responses RetirarAlumno(Long idAl) { // TODO Auto-generated
	 * method stub Responses response=new Responses(); Alumno alumnoAmodificar=new
	 * Alumno(); Alumno alumnoModificado=new Alumno();
	 * alumnoAmodificar=alumnorepo.findById(idAl).orElse(null);
	 * alumnoAmodificar.setStatus("RETIRADO");
	 * alumnoModificado=alumnorepo.save(alumnoAmodificar);
	 * response.setResponseCode(Constantes.ALUMNO_RETIRADO_CODE);
	 * response.setResponseDescription(Constantes.ALUMNO_RETIRADO_DESC);
	 * response.setAlumno(new AlumnoDTO(alumnoModificado)); return response;
	 * 
	 * 
	 * }
     */
    @Override
    public Responses consultarAlumnosPorCursoYmateria(Long idcurso, Long idmateria) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Responses resp = new Responses();

        List<AlumnoDTO> alumnosdto = new ArrayList<>();

        List<Alumno> alumnos = new ArrayList<>();

        alumnos = alumnorepo.findAlumnosByCursoAndMateria(idcurso, idmateria);
        
        if (alumnos != null) {

            for (int i = 0; i < alumnos.size(); i++) {
                Alumno alumno = new Alumno();
                alumno = alumnos.get(i);
                AlumnoDTO alumnodto = new AlumnoDTO(alumno);
                alumnosdto.add(alumnodto);
            }

            resp.setListadeAlumnos(alumnosdto);

        } else {
            resp.setResponseCode(Constantes.CURSO_SIN_INSCRITOS_CODE);
            resp.setResponseDescription(Constantes.CURSO_SIN_INSCRITOS_DESC);
        }


        return resp;
    }

}
