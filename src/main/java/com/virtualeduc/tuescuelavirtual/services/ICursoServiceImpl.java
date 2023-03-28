/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.*;
import com.virtualeduc.tuescuelavirtual.models.DTOS.*;
import com.virtualeduc.tuescuelavirtual.models.mappers.AnnioEscolarMapper;
import com.virtualeduc.tuescuelavirtual.models.mappers.CursoMapper;
import com.virtualeduc.tuescuelavirtual.repo.*;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import com.virtualeduc.tuescuelavirtual.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
@Service
public class ICursoServiceImpl implements ICursoService {

    @Autowired
    IAnnioRepo anniorepo;

    @Autowired
    ISeccionRepo seccionrepo;

    @Autowired
    IAnnioEscolarRepo annioescolarrepo;

    @Autowired
    ITurnoRepo turnorepo;

    @Autowired
    ICursoRepo cursorepo;

    @Autowired
    ICursoProfRepo cursoprofrepo;

    @Autowired
    IViewCursosMateriasAsignada cursosmateriasasignadas;

    @Autowired
    IViewCursosMateriasSinAsignar cursosmateriassinasignar;

    @Autowired
    IViewMateriasPorCurso materiasporcurso;

    @Autowired
    IViewCursosMateriasAsignada materiasasignadas;

    private CursoDTO cursoaguardar;

    private Curso cursoguardado;



    @Override
    public AnnioEscolar consultarAnnioEscolar() {
        return annioescolarrepo.consultarAnnioEscolarVigente();
    }

    @Override
    public Seccion consultarSeccionPorSeccion(String seccion) {
        return seccionrepo.consultarSeccionBySeccion(seccion);
    }

    @Override
    public List<Annio> consultarannios() {
        return anniorepo.findAll();
    }

    @Override
    public List<AnnioEscolar> consultaranniosesc() {
        return annioescolarrepo.findAll();
    }

    @Override
    public List<Seccion> consultarsecciones() {
        return seccionrepo.findAll();
    }

    @Override
    public List<Curso> consultarcursos() {
        return cursorepo.findAll();

    }

    @Override
    public Curso consultarcursoporparametros(Long idannio, Long idannioesc, Long idseccion) {
        return cursorepo.consultarCursoByParametros(idannio, idannioesc, idseccion);
    }

    @Override
    public Optional<List<Curso>> consultarcursosporperiodo(Long idannioesc) {
        return cursorepo.consultarCursosByPeriodo(idannioesc);
    }

    @Override
    public Annio consultarAnnioPorAnnioYnivel(String annio, String nivel) {
        return null;
    }


    @Override
    public Turno consultarTurnoPorTurno(String turno) {
        return turnorepo.consultarTurnoByTurno(turno);
    }

    @Override
    public Curso consultarCursoPorId(Long idcurso) {
        return cursorepo.consultarCursoById(idcurso);
    }

    @Override
    public List<Turno> consultarturnos() {
        return turnorepo.findAll();
    }

    @Override
    public List<String> consultarespecialidades() {
        return anniorepo.especialidades();
    }

    @Override
    public Responses guardarCurso(CursoDTO curso, boolean guardarCurso) {
        // TODO Auto-generated method stub
        Responses resp = null;

        Annio annio = anniorepo.consultarAnnioByAnnioAndNivelAndEspecialidad(curso.getAnnio(), curso.getNivel(), curso.getEspecialidad());

        // Long idAnnio=annio.getIdAnnio();
        Seccion seccion = seccionrepo.consultarSeccionBySeccion(curso.getSeccion());

        // Long idSeccion=seccion.getIdSec();
        Turno turno = turnorepo.consultarTurnoByTurno(curso.getTurno());

        // Long idTurno=turno.getIdTurno();
        AnnioEscolar annioEscolar = annioescolarrepo.consultarAnnioEscolarVigente();

        // Long idAnnioescolar=annioEscolar.getIdAnnioEsc();
        Curso cursoaguardar = new Curso(annio, annioEscolar, seccion, turno);

        if (!guardarCurso) {
            cursoguardado = cursorepo.consultarCursoById(curso.getIdCurso());
            cursoaguardar.setIdCurso(cursoguardado.getIdCurso());
        }

        Curso cursoguardado = cursorepo.save(cursoaguardar);

        Optional<CursoDTO> cursoguardadodto = new CursoMapper().CursoToCursoDto(cursoguardado);

        resp = new Responses();

        resp.setCurso(cursoguardadodto);

        if (guardarCurso) {
            resp.setResponseCode(Constantes.CURSO_REGISTRADO_CODE);

            resp.setResponseDescription(Constantes.CURSO_REGISTRADO_DESC);
        } else {
            resp.setResponseCode(Constantes.CURSO_MODIFICADO_CODE);

            resp.setResponseDescription(Constantes.CURSO_MODIFICADO_DESC);
        }

        /*
		 * cursoaguardardto.setIdAnnio(idAnnio);
		 * 
		 * cursoaguardardto.setIdSec(idSeccion);
		 * 
		 * cursoaguardardto.setIdAnnioEsc(idAnnioescolar);
		 * 
		 * cursoaguardardto.setIdTurno(idTurno);
		 * 
		 * cursoaguardardto.setAnnio(annio.getAnnio());
		 * 
		 * cursoaguardardto.setIntAnnioEsc(annioEscolar.getIntAnnioEsc());
		 * 
		 * cursoaguardardto.setSeccion(seccion.getSeccion());
		 * 
		 * cursoaguardardto.setTurno(turno.getTurno());
		 * 
		 * cursoaguardardto.setNivel(annio.getNivel());
		 * 
		 * cursoaguardardto.setEspecialidad(annio.getEspecialidad());
         */
        return resp;

    }

    @Override
    public Curso cursoporcurso(CursoDTO curso) {
        // TODO Auto-generated method stub
        Annio annio = anniorepo.consultarAnnioByAnnioAndNivelAndEspecialidad(curso.getAnnio(), curso.getNivel(),curso.getEspecialidad());

        Seccion seccion = seccionrepo.consultarSeccionBySeccion(curso.getSeccion());

        Turno turno = turnorepo.consultarTurnoByTurno(curso.getTurno());

        AnnioEscolar annioescolar = annioescolarrepo.consultarAnnioEscolarVigente();

        Curso cursoconsultado = new Curso();

        cursoconsultado = cursorepo.consultarCursoPorParametros(annio.getIdAnnio(), annioescolar.getIdAnnioEsc(),
                seccion.getIdSec(), turno.getIdTurno());

        return cursoconsultado;
    }

    @Override
    public Responses eliminarCurso(Long idcurso) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();

        cursorepo.deleteById(idcurso);

        resp.setResponseCode(Constantes.CURSO_ELIMINADO_CODE);
        resp.setResponseDescription(Constantes.CURSO_ELIMINADO_DESC);

        return resp;
    }

    @Override
    public List<AnnioEscolar> consultarPeriodos() {
        return annioescolarrepo.consultarPeriodosEscolares();
    }

    @Override
    public Responses guardarPeriodo(AnnioEscolarDTO annioescolarDTO, boolean guardarPeriodo) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();

        AnnioEscolar annioEscolarAguardar = new AnnioEscolarMapper().AnnioEscolarDtoToAnnioEscolar(annioescolarDTO);

        if (guardarPeriodo) {

            DesactivarPeriodoVigente();

            AnnioEscolar annioEscolarGuardado = this.annioescolarrepo.save(annioEscolarAguardar);

            resp.setAnnioescolar(new AnnioEscolarMapper().AnnioEscolarToAnnioEscolarDto(annioEscolarGuardado));

            resp.setResponseCode(Constantes.ANNIO_ESCOLAR_REGISTRADO_CODE);

            resp.setResponseDescription(Constantes.ANNIO_ESCOLAR_REGISTRADO_DESC);

        } else {

            Long idAnnioEsc = annioescolarDTO.getIdAnnioEsc();

            annioEscolarAguardar.setIdAnnioEsc(idAnnioEsc);

            annioEscolarAguardar.setIntAnnioEsc(Utils.extraePeriodoEscolar(annioescolarDTO.getFechaI(), annioescolarDTO.getFechaF()));

            AnnioEscolar annioEscolarGuardado = this.annioescolarrepo.save(annioEscolarAguardar);

            resp.setAnnioescolar(new AnnioEscolarMapper().AnnioEscolarToAnnioEscolarDto(annioEscolarGuardado));

            resp.setResponseCode(Constantes.ANNIO_ESCOLAR_MODIFICADO_CODE);

            resp.setResponseDescription(Constantes.ANNIO_ESCOLAR_MODIFICADO_DESC);
        }

        return resp;
    }

    @Override
    public void DesactivarPeriodoVigente() {
        // TODO Auto-generated method stub

        // Consulta el periodo vigente
        Long IdPeriodoVigente;

        AnnioEscolarDTO periodovigente = new AnnioEscolarMapper().AnnioEscolarToAnnioEscolarDto(annioescolarrepo.consultarAnnioEscolarVigente());

        if (periodovigente != null) {

            IdPeriodoVigente = periodovigente.getIdAnnioEsc();

            periodovigente.setStatus("I");

            AnnioEscolar periodo = new AnnioEscolarMapper().AnnioEscolarDtoToAnnioEscolar(periodovigente);

            periodo.setIdAnnioEsc(IdPeriodoVigente);

            this.annioescolarrepo.save(periodo);
        }

    }

    @Override
    public Curso consultarCursoPorIdCurso(Long idCurso) {
        // TODO Auto-generated method stub
        return cursorepo.findById(idCurso).orElse(null);
    }

    @Override
    public Annio consultarAnnioPorAnnioYnivelYespecialidad(String annio, String nivel, String especialidad) {
        return anniorepo.consultarAnnioByAnnioAndNivelAndEspecialidad(annio, nivel, especialidad);
    }

    @Override
    public AnnioEscolar consultarAnnioEscolarPorId(Long idAnnioEscolar) {
        return annioescolarrepo.findById(idAnnioEscolar).orElse(null);
    }

    @Override
    public Responses eliminarPeriodo(Long idAnnioEsc) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();

        annioescolarrepo.deleteById(idAnnioEsc);

        resp.setResponseCode(Constantes.CURSO_ELIMINADO_CODE);

        resp.setResponseDescription(Constantes.CURSO_ELIMINADO_DESC);

        return resp;
    }

    @Override
    public List<String> annios() {
        // TODO Auto-generated method stub
        return anniorepo.annios();
    }

    @Override
    public List<String> niveles() {
        // TODO Auto-generated method stub
        return anniorepo.niveles();
    }

    @Override
    public List<String> especialidades() {
        // TODO Auto-generated method stub
        return anniorepo.especialidades();
    }

    @Override
    public List<ViewCursosMateriasAsignada> consultarMateriasAsignadas() {
        // TODO Auto-generated method stub
        return cursosmateriasasignadas.findAll();
    }

    @Override
    public List<ViewCursosMateriasSinAsignar> consultarMateriasSinAsignar() {
        // TODO Auto-generated method stub
        return cursosmateriassinasignar.findAll();
    }

    @Override
    public List<ViewMateriasPorCurso> consultarMateriaPorCurso() {
        // TODO Auto-generated method stub
        return materiasporcurso.findAll();
    }

    @Override
    public Responses asignarCursosMaterias(List<CursoProf> cursos) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();

        CursoProf cursoprofesor;

        for (CursoProf cursoprof : cursos) {

            cursoprofesor = cursoprofrepo.findCursoProf(cursoprof.getIdCurso(), cursoprof.getIdMat(), cursoprof.getIdProf());

            if (cursoprofesor == null) {
                CursoProf cursoprofesorguardado = cursoprofrepo.save(cursoprof);
                resp.setResponseCode(Constantes.CURSO_MATERIA_ASIGNADA_CODE);
                resp.setResponseDescription(Constantes.CURSO_MATERIA_ASIGNADA_DESC);

            }
        }

        return resp;
    }

    @Override
    public Responses asignarMaterias(List<MateriaProf> materias) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();
        return resp;
    }

    @Override
    public Responses eliminarCursosMateria(Long idProfesor, Long idCurso, Long idMateria) {
        // TODO Auto-generated method stub
        Responses resp = new Responses();

        //Long idCursoMateria=cursoprof.getIdCursoProf();
        CursoProf cursosprof = cursoprofrepo.findCursoProf(idCurso, idMateria, idProfesor);

        if (cursosprof != null) {
            cursoprofrepo.deleteById(cursosprof.getIdCursoProf());
            resp.setResponseCode(Constantes.CURSO_MATERIA_ELIMINADA_CODE);
            resp.setResponseDescription(Constantes.CURSO_MATERIA_ELIMINADA_DESC);
        }

        return resp;
    }

    @Override
    public List<CursoProf> consultarCursosPorProfesor(Long idProfesor) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<CursoProf> cursos_prof = cursoprofrepo.findCursosPorProf(idProfesor);

        return cursos_prof;
    }

    @Override
    public List<ViewCursosMateriasAsignada> consultarcursomateriaprofesor(Long idprofesor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        List<ViewCursosMateriasAsignada> cursomateriaprofesor = materiasasignadas.consultarMateriasPorCursoProfesor(idprofesor);

        return cursomateriaprofesor;
    }

    @Override
    public AnnioEscolar obtenerAnnioEscolarPorId(Long idAnnioEscolar) {
        AnnioEscolar annioescolar = annioescolarrepo.findById(idAnnioEscolar).orElse(null);

        return annioescolar;
    }

}
