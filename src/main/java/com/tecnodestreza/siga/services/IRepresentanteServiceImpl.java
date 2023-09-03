/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Representante;
import com.tecnodestreza.siga.repo.IRepresentanteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@Service
public class IRepresentanteServiceImpl implements IRepresentanteService {
     private final IRepresentanteRepo representanteRepo;

    @Override
    public Optional<Representante> consultarRepresentantePorCedula(String tipodocumento, String numerodocumento) {
        return representanteRepo.findRepresentanteByTipoDocumentoAndNumeroDocumento(tipodocumento, numerodocumento);
    }
    @Override
    public Optional<Representante> crearRepresentante(Representante representante) {
        return Optional.of(representanteRepo.save(representante));
    }
}
