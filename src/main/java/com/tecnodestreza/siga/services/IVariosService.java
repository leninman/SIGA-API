package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.*;

import java.util.List;

public interface IVariosService {
    List<Annio> annios();
    List<Seccion> secciones();
    List<Turno> turnos();
    List<Nivel> niveles();
    List<Condicion> condiciones();

}
