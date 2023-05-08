package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Docente;

import java.util.List;
import java.util.Optional;

public interface IDocenteService {
    Optional<Docente> consultarDocentePorCedula(String tipoDoc, String numDoc);
    List<Docente> consultarDocentes();
    Optional<Docente> guardarDocente(Docente docente,Long idDocente);
    void desactivar(Long idDocente,String condicion);
}
