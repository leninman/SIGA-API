package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.models.Curso;

import com.tecnodestreza.siga.repo.ICursoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = {"direccionbase"})
public class CursoController {
    private final ICursoRepo iCursoRepo;
    @PostMapping(path = "/crear")
    public ResponseEntity<?> crear(@RequestBody Curso curso){
        return ResponseEntity.ok().body(iCursoRepo.save(curso));
    }
}
