/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.Lapso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author lenin
 */
public interface ILapsoRepo extends JpaRepository<Lapso, Long> {
    
      @Query(value="select * from lapsos l "
              + "where l.ID_LAPSO not in("
              + "select ID_LAPSO from notas_par np where np.ID_MAT = ?1 "
              + "and np.ID_CURSO = ?2)",nativeQuery = true)
    public List<Lapso> consultarLapsosDisponibles(Long idMat,Long idCurso);
    

}
