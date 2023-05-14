package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.NotaParcial;

import java.util.Optional;

public interface INotaParcialService {
    Optional<NotaParcial> registrarNotaParcial(NotaParcial notaParcial);
}
