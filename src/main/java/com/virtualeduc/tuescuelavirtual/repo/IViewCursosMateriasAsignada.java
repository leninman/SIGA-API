package com.virtualeduc.tuescuelavirtual.repo;

import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IViewCursosMateriasAsignada extends JpaRepository<ViewCursosMateriasAsignada,String> {
    
     @Query(value="SELECT * FROM view_cursos_materias_asignadas a"
            + " where a.id_prf=?1",nativeQuery = true)
    public List<ViewCursosMateriasAsignada> consultarMateriasPorCursoProfesor(Long idprofesor);

}
