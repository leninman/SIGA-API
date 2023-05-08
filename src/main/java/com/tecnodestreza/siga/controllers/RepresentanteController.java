package com.tecnodestreza.siga.controllers;



import com.tecnodestreza.siga.models.Representante;
import com.tecnodestreza.siga.models.dto.Representantedto;
import com.tecnodestreza.siga.services.IRepresentanteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/representante")
@CrossOrigin(origins = {"sigaBasicUrl"})
public class RepresentanteController {
    private final IRepresentanteService iRepresentanteService;

    //CREAR
    @PostMapping("crear")
    public ResponseEntity<Optional<Representante>> crear(@RequestBody Representantedto representantedto){
        ModelMapper modelMapper=new ModelMapper();
        Representante representante=modelMapper.map(representantedto,Representante.class);
        Optional<Representante> optionalRepresentante=iRepresentanteService.consultarRepresentantePorCedula(representante.getTipoDocumento(),representante.getNumeroDocumento());
        if(optionalRepresentante.isPresent()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(iRepresentanteService.crearRepresentante(representante));
    }
    //CONSULTA POR CEDULA
    @GetMapping(path = "/consultarporcedula")
    public ResponseEntity<Optional<Representante>> consultarporcedula(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return ResponseEntity.ok().body(iRepresentanteService.consultarRepresentantePorCedula(tdoc,ndoc));
    }

}
