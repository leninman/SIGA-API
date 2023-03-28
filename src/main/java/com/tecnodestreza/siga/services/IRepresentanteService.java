/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.DTOS.RepresentanteDTO;
import com.tecnodestreza.siga.models.Representante;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteService {
    
    public Representante consultarepresentanteporid(Long id);
    
    public Representante consultarepresentanteporcedula(String tipodocumento,String numerodocumento);
    
    public RepresentanteDTO obtenerRepresentantePorCedula(String tipodocumento, String numerodocumento);
    
    public Representante guardarRepresentante(Representante representante); 
}
