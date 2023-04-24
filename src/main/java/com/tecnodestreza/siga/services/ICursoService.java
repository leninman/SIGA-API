/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;


import com.tecnodestreza.siga.models.*;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface ICursoService {
      public Optional<Curso> consultarCursoPorParametros(String periodo,String annio,String seccion,String turno,String nivel,String periodoAcademico);
      public Optional<Curso>  crear(Curso curso);
      List<Curso> listarcursos();
}
