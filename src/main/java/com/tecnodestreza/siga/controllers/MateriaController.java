package com.tecnodestreza.siga.controllers;

import com.tecnodestreza.siga.mappers.CursoDocentedtoToCursoDocenteMapper;
import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.CursoDocente;
import com.tecnodestreza.siga.models.Materia;
import com.tecnodestreza.siga.models.dto.CedulaAlumnodto;
import com.tecnodestreza.siga.models.dto.CursoDocentedto;
import com.tecnodestreza.siga.models.dto.Cursodto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;
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
@RequestMapping("/materia")
@CrossOrigin(origins = {"*"})
public class MateriaController {
    private final IMateriaService materiaService;
    public MateriaController(IMateriaService materiaService) {

        this.materiaService = materiaService;

    }
    @GetMapping(path = "/listado")
    public ResponseEntity<List<String>> listado() {
        List<String> materias=materiaService.listadoMaterias();
        return ResponseEntity.ok().body(materias);
    }
}
