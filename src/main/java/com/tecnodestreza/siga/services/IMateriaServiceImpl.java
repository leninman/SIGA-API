package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Materia;
import com.tecnodestreza.siga.repo.IMateriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class IMateriaServiceImpl implements IMateriaService{
    @Autowired
    private IMateriaRepo materiaRepo;

    @Override
    public List<String> listadoMaterias() {
        return materiaRepo.listadoMaterias();
    }

    @Override
    public Optional<Materia> consultarMateriaPorId(Long materiaId) {
        return materiaRepo.findById(materiaId);
    }
}
