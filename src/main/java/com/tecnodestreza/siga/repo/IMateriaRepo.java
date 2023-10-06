package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IMateriaRepo extends JpaRepository<Materia, Long> {
    @Query(value="SELECT distinct (nombre) from materias a "
            ,nativeQuery = true)
    List<String> listadoMaterias();

}
