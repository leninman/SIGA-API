package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.Variosdto;
import com.tecnodestreza.siga.repo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IVariosServiceImpl implements IVariosService{

    private final IAnnioRepo annioRepo;
    private final ISeccionRepo seccionRepo;
    private final ITurnoRepo turnoRepo;
    private final ICondicionRepo condicionRepo;
    private final INivelRepo nivelRepo;
    private final IProfesionRepo profesionRepo;
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

    @Override
    public List<Nacionalidad> obtenernacionalidades() {
        List<Nacionalidad> nacionalidads=nacionalidadRepo.findAll();
        List<Nacionalidad> nacionalidades=new ArrayList<>();

        for(Nacionalidad nacionalidad:nacionalidads){
            nacionalidad.setPaisNac(nacionalidad.getPaisNac().toUpperCase());
            nacionalidades.add(nacionalidad);
        }
        return nacionalidades;
    }

    @Override
    public List<Profesion> obtenerprofesiones() {
        List<Profesion> profesions = profesionRepo.findAll();
        List<Profesion> profesiones = profesions.stream().map(profesion ->
                profesion).collect(Collectors.toList());

        return profesiones;
    }

}
