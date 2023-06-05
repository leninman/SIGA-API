package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.NotaParcial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INotaParcialRepo extends JpaRepository<NotaParcial,Long> {
    List<NotaParcial> findNotaParcialByAlumno_Id(Long idAlumno);
}
