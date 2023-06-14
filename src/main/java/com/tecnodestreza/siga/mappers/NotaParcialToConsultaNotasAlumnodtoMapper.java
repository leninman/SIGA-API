package com.tecnodestreza.siga.mappers;

import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.ConsultaNotasAlumnodto;
import com.tecnodestreza.siga.models.dto.NotaConsultadto;
import com.tecnodestreza.siga.models.dto.NotaParcialdto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class NotaParcialToConsultaNotasAlumnodtoMapper implements Function<List<NotaParcial>, ConsultaNotasAlumnodto> {
    @Override
    public ConsultaNotasAlumnodto apply(List<NotaParcial> notaParcials) {
        ConsultaNotasAlumnodto consultaNotasAlumnodto=new ConsultaNotasAlumnodto();
        consultaNotasAlumnodto.setTipoDocumentoAlumno(notaParcials.get(0).getAlumno().getTipoDocumento());
        consultaNotasAlumnodto.setNumeroDocumentoAlumno(notaParcials.get(0).getAlumno().getNumeroDocumento());
        consultaNotasAlumnodto.setPrimerNombreAlumno(notaParcials.get(0).getAlumno().getPrimerNombre());
        consultaNotasAlumnodto.setPrimerApellidoAlumno(notaParcials.get(0).getAlumno().getPrimerApellido());
        consultaNotasAlumnodto.setSegundoNombreAlumno(notaParcials.get(0).getAlumno().getSegundoNombre());
        consultaNotasAlumnodto.setSegundoApellidoAlumno(notaParcials.get(0).getAlumno().getSegundoApellido());
        consultaNotasAlumnodto.setAnnio(notaParcials.get(0).getCurso().getAnnio());
        consultaNotasAlumnodto.setSeccion(notaParcials.get(0).getCurso().getSeccion());
        consultaNotasAlumnodto.setPeriodo(notaParcials.get(0).getCurso().getPeriodoAcademico());
        consultaNotasAlumnodto.setTurno(notaParcials.get(0).getCurso().getTurno());

        List<NotaConsultadto> notas=new ArrayList<>();
        for(NotaParcial notaParcial:notaParcials){
            NotaConsultadto notaConsultadto=new NotaConsultadto(notaParcial.getMateria().getNombre(),notaParcial.getNota(),notaParcial.getLapso(),notaParcial.getPorcentaje());
            notas.add(notaConsultadto);
        }
        consultaNotasAlumnodto.setNotas(notas);
        return consultaNotasAlumnodto;
    }
}
