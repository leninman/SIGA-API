package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.NotaParcial;
import com.tecnodestreza.siga.models.dto.ConsultaNotasAlumnodto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;

import java.util.List;
import java.util.Optional;

public interface INotaParcialService {
    List<NotaParcial> registrarNotasParciales(List<NotaParcial> notasParciales);
    Optional<ConsultaNotasAlumnodto> consultarNotasParciales(PersonaDocumentodto cedula,String lapso);
}
