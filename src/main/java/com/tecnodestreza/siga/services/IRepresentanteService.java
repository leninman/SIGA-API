/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Representante;

import java.util.Optional;

/**
 *
 * @author Lenin
 */
public interface IRepresentanteService {
    public Optional<Optional<Representante>> consultarRepresentantePorId(Long id);
    public Optional<Representante> consultarRepresentantePorCedula(String tipodocumento, String numerodocumento);
    public Optional<Representante> crearRepresentante(Representante representante);
}
