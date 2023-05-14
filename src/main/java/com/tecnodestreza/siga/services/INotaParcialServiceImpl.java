package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.NotaParcial;
import com.tecnodestreza.siga.repo.INotaParcialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class INotaParcialServiceImpl implements INotaParcialService {

    @Autowired
    INotaParcialRepo notaParcialRepo;
    @Override
    public Optional<NotaParcial> registrarNotaParcial(NotaParcial notaParcial) {
        return Optional.empty();
    }
}
