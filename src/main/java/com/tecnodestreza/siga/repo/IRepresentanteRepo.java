/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Representante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteRepo extends CrudRepository<Representante,Long> {
    Representante findRepresentanteByTipoDocumentoAndNumeroDocumento(String tipoDocumento,String numeroDocumento);

}
