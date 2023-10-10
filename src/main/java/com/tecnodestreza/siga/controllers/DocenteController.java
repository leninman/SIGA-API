package com.tecnodestreza.siga.controllers;




import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.dto.Docentedto;
import com.tecnodestreza.siga.models.dto.ListadoAlumnosdto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;
import com.tecnodestreza.siga.services.IDocenteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/docente")
@CrossOrigin(origins = {"*"})
public class DocenteController {
    private final IDocenteService docenteService;


    //CONSULTA LA LISTA COMPLETA DE DOCENTES ACTIVOS
    @GetMapping(path = "/listado")
    public ResponseEntity<List<Docente>> listado() {
       List<Docente> docentes=docenteService.consultarDocentes();
        return ResponseEntity.ok().body(docentes);
    }

  //  @PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PostMapping("crear")
    public ResponseEntity<Optional<Docente>> crear(@RequestBody Docentedto docentedto) {
        ModelMapper modelMapper=new ModelMapper();
        Docente docente=modelMapper.map(docentedto,Docente.class);
        Optional<Docente> optionalDocente=docenteService.consultarDocentePorCedula(docente.getTipoDocumento(),docente.getNumeroDocumento());
        if(optionalDocente.isPresent()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.guardarDocente(docente,null));
    }
    @PutMapping("modificar/{idDocente}")
    public ResponseEntity<Optional<Docente>> modificar(@RequestBody Docentedto docentedto, @PathVariable Long idDocente) {
        ModelMapper modelMapper=new ModelMapper();
        Docente docente=modelMapper.map(docentedto,Docente.class);
        return ResponseEntity.status(HttpStatus.OK).body(docenteService.guardarDocente(docente,idDocente));
    }

    //CONSULTA POR CEDULA
    @GetMapping(path = "/consultarporcedula",
            produces = "application/json")
    public ResponseEntity<Optional<Docente>> consultarporcedula(@RequestBody PersonaDocumentodto personaDocumentodto) {
        Optional<Docente> docente = docenteService.consultarDocentePorCedula(personaDocumentodto.getTipoDocumento(), personaDocumentodto.getNumeroDocumento());
        if (!docente.isPresent())
            return ResponseEntity.ok(Optional.empty());
        else
            return ResponseEntity.ok().body(docente);
    }
    @GetMapping(path = "/consultarporid/{id}",
            produces = "application/json")
    public ResponseEntity<Optional<Docente>> consultarporid(@PathVariable Long id) {
        Optional<Docente> docente = docenteService.consultarDocentePorId(id);
        if (!docente.isPresent())
            return ResponseEntity.ok(Optional.empty());
        else
            return ResponseEntity.ok().body(docente);
    }


}
