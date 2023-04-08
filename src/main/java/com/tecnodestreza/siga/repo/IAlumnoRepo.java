/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Personal
 */
public interface IAlumnoRepo extends JpaRepository<Alumno, Long> {

    @Query(value="SELECT a from alumnos a "
                    + "WHERE a.STATUS='ACTIVO'",nativeQuery = true)
    public List<Alumno> consultarAlumnos();

    @Query(value="SELECT a from alumnos a "
            + "WHERE a.TIPO_DOC_AL=?1 and a.NUM_DOC_AL=?2 and a.STATUS='ACTIVO'",nativeQuery = true)
    public Alumno consultarAlumnoPorCedula(String tipoDocAl, String numDocAl);
}
