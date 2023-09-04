package com.tecnodestreza.siga.controllers;


import com.tecnodestreza.siga.models.Nacionalidad;
import com.tecnodestreza.siga.models.Profesion;
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
@RequestMapping("/profesiones")
@CrossOrigin(origins = {"*"})
public class ProfesionController {
    private final IVariosService variosService;

    @GetMapping
    public ResponseEntity<List<Profesion>> profesiones() {
        List<Profesion> profesiones=variosService.obtenerprofesiones();
        return ResponseEntity.ok().body(profesiones);
    }


}
