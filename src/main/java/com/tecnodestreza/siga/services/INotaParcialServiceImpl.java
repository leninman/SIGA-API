package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.mappers.NotaParcialToConsultaNotasAlumnodtoMapper;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.ConsultaNotasAlumnodto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;
import com.tecnodestreza.siga.repo.*;
import com.tecnodestreza.siga.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class INotaParcialServiceImpl implements INotaParcialService {

    @Autowired
    INotaParcialRepo notaParcialRepo;
    @Autowired
    ILapsoRepo lapsoRepoRepo;
    @Autowired
    IAlumnoRepo alumnoRepo;
    @Override
    public List<NotaParcial> registrarNotasParciales(List<NotaParcial> notasParciales) {
        List<NotaParcial> notasRegistradas=new ArrayList<>();
        for(NotaParcial notaParcial:notasParciales){
            Optional<Lapso> lapso=lapsoRepoRepo.findLapsoByValor(notaParcial.getLapso());
            String porcentaje=Utils.calcularPorcentajeNota(notaParcial.getNota(),lapso.get().getPorcentaje());
            notaParcial.setPorcentaje(porcentaje);
            NotaParcial notaParcialRegistrada=notaParcialRepo.save(notaParcial);
            notasRegistradas.add(notaParcialRegistrada);
        }
        return notasRegistradas;
    }

    @Override
    public ConsultaNotasAlumnodto consultarNotasParciales(PersonaDocumentodto cedula) {
        Long idAlumno=(alumnoRepo.findAlumnoByTipoDocumentoAndNumeroDocumento(cedula.getTipoDocumento(), cedula.getNumeroDocumento())).get().getId();
        (notaParcialRepo.findNotaParcialByAlumno_Id(idAlumno)).stream().map(NotaParcial ->
                new NotaParcialToConsultaNotasAlumnodtoMapper().apply(NotaParcial));
        return null;
    }
}
