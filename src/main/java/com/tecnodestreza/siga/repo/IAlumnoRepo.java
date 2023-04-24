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
 * @author Personal
 */
public interface IAlumnoRepo extends JpaRepository<Alumno, Long> {

    @Query(value="SELECT a from Alumno a "
                    + "WHERE a.activo=true")
    public List<Alumno> consultarAlumnos();
    Optional<Alumno> findAlumnoByTipoDocumentoAndNumeroDocumento(String tipoDocuemnto, String numeroDocumento);
}
