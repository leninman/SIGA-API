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
    @GetMapping(path = "/nacionalidades")
    public ResponseEntity<List<Nacionalidad>> nacionalidades() {
        List<Nacionalidad> nacionalidades=variosService.nacionalidades();
        return ResponseEntity.ok().body(nacionalidades);
    }
    @GetMapping(path = "/sexos")
    public ResponseEntity<List<Sexo>> sexos() {
        List<Sexo> sexos=variosService.sexos();
        return ResponseEntity.ok().body(sexos);
    }
    @GetMapping(path = "/estadocivil")
    public ResponseEntity<List<EstadoCivil>> estadocivil() {
        List<EstadoCivil> estadoCivils=variosService.estadocivil();
        return ResponseEntity.ok().body(estadoCivils);
    }
    @GetMapping(path = "/lapsos")
    public ResponseEntity<List<Lapso>> lapsos() {
        List<Lapso> lapsos=variosService.lapsos();
        return ResponseEntity.ok().body(lapsos);
    }
}
