package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.Variosdto;
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
    private final INacionalidadRepo nacionalidadRepo;
    private final ISexoRepo sexoRepo;
    private final IEstadoCivilRepo estadoCivilRepo;
    private final ILapsoRepo lapsoRepo;

    @Override
    public Variosdto obtenervarios() {

        return new Variosdto(annioRepo.findAll(),
                            seccionRepo.findAll(),
                            turnoRepo.findAll(),
                            nivelRepo.findAll(),
                            condicionRepo.findAll(),
                            nacionalidadRepo.findAll(),
                            sexoRepo.findAll(),
                            estadoCivilRepo.findAll(),
                            lapsoRepo.findAll());
    }

}
