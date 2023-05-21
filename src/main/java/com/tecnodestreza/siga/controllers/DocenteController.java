package com.tecnodestreza.siga.controllers;




import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.dto.Docentedto;
import com.tecnodestreza.siga.services.IDocenteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/docente")
@CrossOrigin(origins = {"sigaBasicUrl"})
public class DocenteController {
    private final IDocenteService docenteService;

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


}
