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
        Optional<Lapso> lapso=lapsoRepoRepo.findLapsoByValor(notasParciales.get(0).getLapso());
        for(NotaParcial notaParcial:notasParciales){
            //VALIDA LA EXISTENCIA DE LA NOTA DE ESA MATERIA EN ESE LAPSO ANTES DE GUARDAR
            if(!notaParcialRepo.findNotaParcialsByAlumnoIdAndMateriaCodigoAndLapso(notaParcial.getAlumno().getId(),notaParcial.getMateria().getCodigo(),notaParcial.getLapso()).isPresent() && lapso.isPresent()){
                String porcentaje=Utils.calcularPorcentajeNota(notaParcial.getNota(),lapso.get().getPorcentaje());
                notaParcial.setPorcentaje(porcentaje);
                NotaParcial notaParcialRegistrada=notaParcialRepo.save(notaParcial);
                notasRegistradas.add(notaParcialRegistrada);
            }
        }
        return notasRegistradas;
    }

    @Override
    public Optional<ConsultaNotasAlumnodto> consultarNotasParciales(PersonaDocumentodto cedula,String lapso) {
        Optional<Alumno> alumno=alumnoRepo.findAlumnoByTipoDocumentoAndNumeroDocumento(cedula.getTipoDocumento(), cedula.getNumeroDocumento());
        Optional<ConsultaNotasAlumnodto> consultaNotasAlumnodto=Optional.empty();
        if (alumno.isPresent()) {
            Long idAlumno = alumno.get().getId();
            if(lapso!=null) {
                if (!(notaParcialRepo.findNotaParcialsByAlumnoIdAndLapso(idAlumno, lapso)).isEmpty()) {
                    consultaNotasAlumnodto = Optional.of(new NotaParcialToConsultaNotasAlumnodtoMapper().apply(notaParcialRepo.findNotaParcialsByAlumnoIdAndLapso(idAlumno, lapso)));
                }
            }else{
                consultaNotasAlumnodto = Optional.of(new NotaParcialToConsultaNotasAlumnodtoMapper().apply(notaParcialRepo.findNotaParcialsByAlumnoId(idAlumno)));
            }
        }

        return consultaNotasAlumnodto;


    }
}
