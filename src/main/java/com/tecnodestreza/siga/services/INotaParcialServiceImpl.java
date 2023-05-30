package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.repo.*;
import com.tecnodestreza.siga.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class INotaParcialServiceImpl implements INotaParcialService {

    @Autowired
    INotaParcialRepo notaParcialRepo;

    @Override
    public Optional<NotaParcial> registrarNotaParcial(NotaParcial notaParcial) {
        String valorPorcentualNota=Utils.calcularPorcentajeNota(notaParcial.getNota(),notaParcial.getLapso());
        notaParcial.setPorcentaje(valorPorcentualNota);
        return Optional.of(notaParcialRepo.save(notaParcial));
    }
}
