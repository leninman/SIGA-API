package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.CursoDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICursoDocenteRepo extends JpaRepository<CursoDocente, Long> {
    @Query(value="SELECT cd from CursoDocente cd "
            + "WHERE cd.docente.id=?1")
    List<CursoDocente> consultarCursosPorDocente(Long idDocente);
}
