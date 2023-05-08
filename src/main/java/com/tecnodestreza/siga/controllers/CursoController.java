package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.models.Curso;

import com.tecnodestreza.siga.models.dto.Cursodto;
import com.tecnodestreza.siga.services.ICursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = {"sigaBasiUrl"})
public class CursoController {
    private final ICursoService cursoService;

    //CREAR CURSO
    @PostMapping(path = "/crear")
    public ResponseEntity<Optional<Curso>> crear(@RequestBody Cursodto cursodto){
        ModelMapper modelMapper=new ModelMapper();
        Curso curso=modelMapper.map(cursodto,Curso.class);
        Optional<Curso> optionalCurso=cursoService.consultarCursoPorParametros(curso.getPeriodoAcademico(), curso.getAnnio(),curso.getSeccion(),curso.getTurno(),curso.getNivel(),curso.getPeriodoAcademico());
        if(optionalCurso.isPresent()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(curso));
    }
    @GetMapping(path = "/listado")
    public ResponseEntity<List<Curso>> listado() {
        List<Curso> cursos=cursoService.listarcursos();
        return ResponseEntity.ok().body(cursos);
    }


}
