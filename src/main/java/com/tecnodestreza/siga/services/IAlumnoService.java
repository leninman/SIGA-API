/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.DTOS.AlumnoDTO;
import com.tecnodestreza.siga.models.Responses;

import java.util.List;

/**
 *
 * @author Personal
 */
public interface IAlumnoService {
    public Alumno consultarAlumnoPorCedula(String tipoDocAl, String numDocAl);
    public Alumno consultarAlumnoPorId(Long id);
    public List<AlumnoDTO> consultarAlumnos();
    public Responses guardarAlumno(AlumnoDTO alumnoDTO,Boolean modificar);
    public Responses modificarAlumno(AlumnoDTO alumnoDTO,Long idAlumno,Boolean modificar);
    public List<AlumnoDTO> consultarTodosLosAlumnos();
    public Long[] consultarIdAlumnoPorIdCurso(Long idcurso);
    public String consultarCedulasDeAlumnos(String tipoDocAl, String numDocAl);
    public Responses consultarAlumnosPorCurso(Long idcurso);
    public Responses consultarAlumnosPorCursoYmateria(Long idcurso,Long idmateria);
}
