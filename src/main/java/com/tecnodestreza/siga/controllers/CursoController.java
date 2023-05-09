package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.mappers.CursoDocentedtoToCursoDocenteMapper;
import com.tecnodestreza.siga.models.Curso;

import com.tecnodestreza.siga.models.CursoDocente;
import com.tecnodestreza.siga.models.dto.CursoDocentedto;
import com.tecnodestreza.siga.models.dto.Cursodto;
import com.tecnodestreza.siga.services.ICursoService;
import com.tecnodestreza.siga.services.IDocenteService;
import com.tecnodestreza.siga.services.IMateriaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = {"sigaBasiUrl"})
public class CursoController {
    private final ICursoService cursoService;
    private final IMateriaService materiaService;
    private final IDocenteService docenteService;

    public CursoController(ICursoService cursoService, IMateriaService materiaService, IDocenteService docenteService) {
        this.cursoService = cursoService;
        this.materiaService = materiaService;
        this.docenteService = docenteService;
    }

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

    @PostMapping(path = "/asignardocente")
    public ResponseEntity<Optional<CursoDocente>> asignardocente(@RequestBody CursoDocentedto cursoDocentedto){
        CursoDocente cursoDocente=new CursoDocentedtoToCursoDocenteMapper(materiaService, docenteService, cursoService).apply(cursoDocentedto);
        Optional<CursoDocente> cursoDocenteGuardado=cursoService.asignarcursos(cursoDocente);
        return ResponseEntity.ok().body(cursoDocenteGuardado);
    }



}
