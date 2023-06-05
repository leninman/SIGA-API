package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.mappers.NotaParcialdtoToNotaParcialMapper;
import com.tecnodestreza.siga.models.NotaParcial;
import com.tecnodestreza.siga.models.dto.NotasParcialesdto;
import com.tecnodestreza.siga.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/notas")
@CrossOrigin(origins = {"*"})
public class NotaController {
    private final IAlumnoService alumnoService;
    private final IMateriaService materiaService;
    private final IDocenteService docenteService;
    private final ICursoService cursoService;
    private final INotaParcialService notaParcialService;

    public NotaController(IAlumnoService alumnoService, IMateriaService materiaService, IDocenteService docenteService, ICursoService cursoService, INotaParcialService notaParcialService) {
        this.alumnoService = alumnoService;
        this.materiaService = materiaService;
        this.docenteService = docenteService;
        this.cursoService = cursoService;
        this.notaParcialService = notaParcialService;
    }


    @PostMapping("crear")
    public ResponseEntity<List<NotaParcial>> crear(@RequestBody NotasParcialesdto notasParciales) {

        List<NotaParcial> notas=notasParciales.getNotasParcialesdto().stream().map(notaParcialdto ->
         new NotaParcialdtoToNotaParcialMapper(materiaService,docenteService,cursoService,alumnoService).apply(notaParcialdto)).collect(Collectors.toList());

        List<NotaParcial> notasRegistradas=notaParcialService.registrarNotasParciales(notas);

        return ResponseEntity.ok().body(notasRegistradas);
    }
}
