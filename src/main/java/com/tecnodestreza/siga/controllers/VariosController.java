package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.models.Annio;
import com.tecnodestreza.siga.models.dto.ListadoAlumnosdto;
import com.tecnodestreza.siga.services.IVariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/varios")
@CrossOrigin(origins = {"*"})
public class VariosController {
    private final IVariosService variosService;
    @GetMapping(path = "/annios")
    public ResponseEntity<List<Annio>> annios() {
        List<Annio> annios=variosService.annios();
        return ResponseEntity.ok().body(annios);
    }
}
