/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;


import com.virtualeduc.tuescuelavirtual.models.*;
import com.virtualeduc.tuescuelavirtual.models.DTOS.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface ICursoService {
    
    
      public List<Annio> consultarannios();
      
      public List<AnnioEscolar> consultaranniosesc();
      
      public List<Seccion> consultarsecciones();
      
      public List<Turno>  consultarturnos();

      public List<String>  consultarespecialidades();
      
      public List<Curso> consultarcursos();
      
      public Curso consultarcursoporparametros(Long idannio,Long idannioesc,Long idseccion);
      
      public Optional<List<Curso>> consultarcursosporperiodo(Long idannioesc);
     
      public Annio consultarAnnioPorAnnioYnivel(String annio,String nivel);
      
      public Annio consultarAnnioPorAnnioYnivelYespecialidad(String annio,String nivel,String especialidad);
      
      public AnnioEscolar consultarAnnioEscolar();
      
      public List<AnnioEscolar> consultarPeriodos();
      
      public AnnioEscolar consultarAnnioEscolarPorId(Long idAnnioEscolar);
      
      public AnnioEscolar obtenerAnnioEscolarPorId(Long idAnnioEscolar);
      
      public Responses eliminarPeriodo(Long idAnnioEsc);
      
      public Seccion consultarSeccionPorSeccion(String seccion);
      
      public Turno consultarTurnoPorTurno(String turno);
      
      public Curso consultarCursoPorId(Long idcurso);
      
      public Responses  guardarCurso(CursoDTO curso,boolean guardarCurso);
      
      public Curso cursoporcurso(CursoDTO curso);
      
      public Responses eliminarCurso(Long idcurso);
      
      public Responses  guardarPeriodo(AnnioEscolarDTO annioescolar,boolean guardarPeriodo);
      
      public void DesactivarPeriodoVigente();
      
      public Curso consultarCursoPorIdCurso(Long idCurso);
      
      public List<String> annios();
      
      public List<String> niveles();
      
      public List<String> especialidades();
      
      public List<ViewCursosMateriasAsignada> consultarMateriasAsignadas();
      
      public List<ViewCursosMateriasSinAsignar> consultarMateriasSinAsignar();
      
      public List<ViewMateriasPorCurso> consultarMateriaPorCurso();
      
      public List<CursoProf> consultarCursosPorProfesor(Long idProfesor);
      
      public Responses asignarCursosMaterias(List<CursoProf> cursosprof);
      
      public Responses asignarMaterias(List<MateriaProf> materiasprof);
      
      public Responses eliminarCursosMateria(Long idPrf,Long idCurso,Long idMat);
      
      public List<ViewCursosMateriasAsignada> consultarcursomateriaprofesor(Long idprofesor);



      
      
      
}
