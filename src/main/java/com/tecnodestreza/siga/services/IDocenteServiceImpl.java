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
        Optional<Docente> docente=docenteRepo.findDocenteByTipoDocumentoAndNumeroDocumento(tipoDoc,numDoc);
        return docente;
    }

    @Override
    public List<Docente> consultarDocentes() {
        return docenteRepo.consultarDocentes();
    }

    @Override
    public Optional<Docente> guardarDocente(Docente docente, Long idDocente) {
        Docente docenteGuardado=new Docente();
        if(idDocente!=null){  //MODIFICAR
            Optional<Docente> optionalDocenteGuardado=docenteRepo.findById(idDocente);
            docente.setId(idDocente);
            docente.setFechaCreacion(optionalDocenteGuardado.get().getFechaCreacion());
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
            docente.get().setCondicion(condicion);
        }
        docenteRepo.save(docente.get());
    }
}
