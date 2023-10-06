package com.tecnodestreza.siga.controllers;


import com.tecnodestreza.siga.models.Nacionalidad;
import com.tecnodestreza.siga.models.dto.Variosdto;
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
@RequestMapping("/nacionalidades")
@CrossOrigin(origins = {"*"})
public class VariosController {
    private final IVariosService variosService;

    @GetMapping
    public ResponseEntity<List<Nacionalidad>> nacionalidades() {
        List<Nacionalidad> nacionalidads=variosService.obtenernacionalidades();
        return ResponseEntity.ok().body(nacionalidads);
    }

}
