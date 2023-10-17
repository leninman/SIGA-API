package com.tecnodestreza.siga.services;


import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.repo.IDocenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class IDocenteServiceImpl implements IDocenteService{
    @Autowired
    IDocenteRepo docenteRepo;
    @Override
    public Optional<Docente> consultarDocentePorCedula(String tipoDoc, String numDoc) {
         return docenteRepo.findDocenteByTipoDocumentoAndNumeroDocumento(tipoDoc,numDoc);
    }

    @Override
    public Optional<Docente> consultarDocentePorId(Long docenteId) {
        return docenteRepo.findById(docenteId);
    }

    @Override
    public List<Docente> consultarDocentes() {
        return docenteRepo.consultarDocentes();
    }

    @Override
    public Optional<Docente> guardarDocente(Docente docente, Long idDocente) {
        Docente docenteGuardado;
        if(idDocente!=null){  //MODIFICAR
            Optional<Docente> optionalDocenteGuardado=docenteRepo.findById(idDocente);
            docente.setId(idDocente);
            if(optionalDocenteGuardado.isPresent()) {
                docente.setFechaCreacion(optionalDocenteGuardado.get().getFechaCreacion());
            }
        }
        docente.setFechaCreacion(new Date());
        if(docente.getCondicion().equals("EN EJERCICIO")){
            docente.setActivo(true);
        }else{
            docente.setActivo(false);
        }
        docenteGuardado=docenteRepo.save(docente);
        return Optional.of(docenteGuardado);
    }

    @Override
    public void desactivar(Long idDocente, String condicion) {
        Optional<Docente> docente=docenteRepo.findById(idDocente);
        if(docente.isPresent()){
            docente.get().setActivo(false);
            docente.get().setCondicion(condicion.toUpperCase());
            docenteRepo.save(docente.get());
        }

    }
}
