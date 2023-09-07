/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;


import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.CedulaAlumnodto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface ICursoService {
      Optional<Curso> consultarCursoPorParametros(String annio,String seccion,String turno,String nivel,String periodoAcademico);
      Optional<Curso> consultarCursoPorId(Long cursoId);
      Optional<Curso>  crear(Curso curso);
      List<Curso> listarcursos();
      Optional<CursoDocente> asignarcursos(CursoDocente cursoDocente);
      Curso cargarcurso(CedulaAlumnodto cedulas, Long idcurso);
      List<CursoDocente> consultarCursosPorDocente(PersonaDocumentodto cedula);
      void asignarNumeroDeLista(List<Alumno> alumnos);
}
