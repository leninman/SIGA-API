package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class IVariosServiceImpl implements IVariosService{

    private final IAnnioRepo annioRepo;
    private final ISeccionRepo seccionRepo;
    private final ITurnoRepo turnoRepo;
    private final ICondicionRepo condicionRepo;
    private final INivelRepo nivelRepo;
    @Override
    public List<Annio> annios() {
        return annioRepo.findAll();
    }

    @Override
    public List<Seccion> secciones() {
        return seccionRepo.findAll();
    }

    @Override
    public List<Turno> turnos() {
        return turnoRepo.findAll();
    }

    @Override
    public List<Nivel> niveles() {
        return nivelRepo.findAll();
    }

    @Override
    public List<Condicion> condiciones() {
        return condicionRepo.findAll();
    }
}
