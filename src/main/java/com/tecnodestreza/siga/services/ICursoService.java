/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;


import com.tecnodestreza.siga.models.*;


import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface ICursoService {
      public Optional<Curso> consultarCursoPorId(Long idcurso);
      public Optional<Curso>  crearCurso(Curso curso, boolean guardarCurso);
}
