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
    public Optional<Alumno> consultarAlumnoPorCedula(String tipoDocAl, String numDocAl);
    public Optional<Alumno> consultarAlumnoPorId(Long idAlumno);
    public List<Alumno> consultarAlumnos();
    public Optional<Alumno> crearAlumno(Alumno alumno,Boolean modificar);
    public Optional<Alumno> modificarAlumno(Alumno alumno,Long idAlumno,Boolean modificar);
}
