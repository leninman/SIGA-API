package com.tecnodestreza.siga.controllers;


import com.tecnodestreza.siga.services.IRepresentanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/representante")
@CrossOrigin(origins = {"direccionbase"})
public class RepresentanteController {
    private final IRepresentanteService iRepresentanteService;
    //CONSULTA DE REPRESENTANTE POR CEDULA
    @GetMapping(path = "/consultarporcedula")
    public ResponseEntity<?> consultarporcedula(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return ResponseEntity.ok().body(iRepresentanteService.consultarRepresentantePorCedula(tdoc,ndoc));
    }
}
