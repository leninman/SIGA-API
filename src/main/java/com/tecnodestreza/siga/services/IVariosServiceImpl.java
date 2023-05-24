package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.repo.IAnnioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class IVariosServiceImpl implements IVariosService{

    private final IAnnioRepo annioRepo;
    @Override
    public List<Annio> annios() {
        return annioRepo.findAll();
    }

    @Override
    public List<Seccion> secciones() {
        return null;
    }

    @Override
    public List<Turno> turnos() {
        return null;
    }

    @Override
    public List<Nivel> niveles() {
        return null;
    }

    @Override
    public List<Condicion> condiciones() {
        return null;
    }
}
