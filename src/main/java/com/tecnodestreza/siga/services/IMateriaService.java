package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Materia;

import java.util.List;
import java.util.Optional;

public interface IMateriaService {
    List<String> listadoMaterias();
    Optional<Materia> consultarMateriaPorId(Long materiaId);
}
