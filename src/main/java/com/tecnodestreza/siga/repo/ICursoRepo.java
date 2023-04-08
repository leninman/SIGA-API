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
import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface ICursoRepo extends JpaRepository<Curso, Long> {
    @Query(value="SELECT a from Curso a "
            + "WHERE a.annio=?1 and a.seccion=?2 and a.periodoAcademico=?3 and a.turno=?4 and a.nivel=?5 and a.especialidad=?6")
    Optional<Curso> consultarCursosPorParametros(String annio,String seccion,String periodoAcademico,String turno,String nivel,String especialidad);
}
