package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IDocenteRepo extends JpaRepository<Docente, Long> {
    @Query(value="SELECT a from Docente a "
            + "WHERE a.activo=true")
    public List<Docente> consultarDocentes();

    Optional<Docente> findDocenteByTipoDocumentoAndNumeroDocumento(String tipoDoc,String numeroDoc);
}
