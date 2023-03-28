/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.repo;


import com.virtualeduc.tuescuelavirtual.models.Representante;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteRepo extends CrudRepository<Representante,Long> {
    
    @Query(value="SELECT * from representantes u"
           + " WHERE u.ID_RPR=?1",nativeQuery = true)
    Representante findRepresentantePorId(Long idRpr);
    
    Representante findRepresentanteByTipoDocRprAndNumDocRpr(String tipoDocRpr,String numDocRpr);

}
