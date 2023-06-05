package com.tecnodestreza.siga.controllers;


import com.tecnodestreza.siga.models.dto.Variosdto;
import com.tecnodestreza.siga.services.IVariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/varios")
@CrossOrigin(origins = {"*"})
public class VariosController {
    private final IVariosService variosService;

    @GetMapping
    public ResponseEntity<Variosdto> varios() {
        Variosdto variosdto=variosService.obtenervarios();
        return ResponseEntity.ok().body(variosdto);
    }

}
