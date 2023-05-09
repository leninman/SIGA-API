package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.CursoDocente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoDocenteRepo extends JpaRepository<CursoDocente, Long> {
}
