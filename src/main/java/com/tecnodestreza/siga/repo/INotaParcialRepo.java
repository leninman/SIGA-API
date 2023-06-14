package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.NotaParcial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface INotaParcialRepo extends JpaRepository<NotaParcial,Long> {
    List<NotaParcial> findNotaParcialsByAlumnoIdAndLapso(Long idAlumno,String lapso);
    List<NotaParcial> findNotaParcialsByAlumnoId(Long idAlumno);
    Optional<NotaParcial> findNotaParcialsByAlumnoIdAndMateriaCodigoAndLapso(Long idAlumno,String codigoMateria,String lapso);
}
