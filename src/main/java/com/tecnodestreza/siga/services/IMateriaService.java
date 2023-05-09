package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Materia;

import java.util.Optional;

public interface IMateriaService {
    Optional<Materia> consultarMateriaPorId(Long materiaId);
}
