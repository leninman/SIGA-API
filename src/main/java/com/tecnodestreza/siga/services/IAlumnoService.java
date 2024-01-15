/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Alumno;


import java.util.List;
import java.util.Optional;

/**
 *
 * @author Personal
 */
public interface IAlumnoService {
    Optional<Alumno> consultarAlumnoPorCedula(String tipoDocAl, String numDocAl);
    Optional<Alumno> consultarAlumnoPorId(Long alumnoId);
    List<Alumno> consultarAlumnos();
    Optional<Alumno> guardarAlumno(Alumno alumno,Long idAlumno);
    Boolean desactivar(Long idAlumno,String condicion);
    List<Alumno> alumnosPorCurso(Long idCurso);
    void reordenarListas(Long idCurso,Alumno nuevoAlumno);
}
