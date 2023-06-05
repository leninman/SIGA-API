package com.tecnodestreza.siga.models.dto;

import com.tecnodestreza.siga.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Variosdto {
    private List<Annio> annios;
    private List<Seccion> secciones;
    private List<Turno> turno;
    private List<Nivel> niveles;
    private List<Condicion> condiciones;
    private List<Nacionalidad> nacionalidades;
    private List<Sexo> sexos;
    private List<EstadoCivil> estadoCivils;
    private List<Lapso> lapsos;







}
