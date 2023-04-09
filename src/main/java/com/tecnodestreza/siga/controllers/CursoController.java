package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.models.Curso;

import com.tecnodestreza.siga.repo.ICursoRepo;
import com.tecnodestreza.siga.services.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = {"direccionbase"})
public class CursoController {
    private final ICursoService iCursoService;

    //CREAR
    @PostMapping(path = "/crear")
    public ResponseEntity<?> crear(@RequestBody Curso curso){
        Optional<Curso> optionalCurso=iCursoService.consultarCursoPorParametros(curso.getPeriodoAcademico(), curso.getAnnio(),curso.getSeccion(),curso.getTurno(),curso.getNivel(),curso.getEspecialidad(), curso.getPeriodoAcademico());
        if(optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(iCursoService.crear(curso));
    }
}
