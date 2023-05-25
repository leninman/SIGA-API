package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.models.*;
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
    @GetMapping(path = "/secciones")
    public ResponseEntity<List<Seccion>> secciones() {
        List<Seccion> secciones=variosService.secciones();
        return ResponseEntity.ok().body(secciones);
    }
    @GetMapping(path = "/turnos")
    public ResponseEntity<List<Turno>> turnos() {
        List<Turno> turnos=variosService.turnos();
        return ResponseEntity.ok().body(turnos);
    }
    @GetMapping(path = "/niveles")
    public ResponseEntity<List<Nivel>> niveles() {
        List<Nivel> niveles=variosService.niveles();
        return ResponseEntity.ok().body(niveles);
    }
    @GetMapping(path = "/condiciones")
    public ResponseEntity<List<Condicion>> condiciones() {
        List<Condicion> condiciones=variosService.condiciones();
        return ResponseEntity.ok().body(condiciones);
    }
}
