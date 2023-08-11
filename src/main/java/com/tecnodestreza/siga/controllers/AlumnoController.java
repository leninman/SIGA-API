/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.controllers;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.models.dto.Alumnodto;
import com.tecnodestreza.siga.models.dto.ListadoAlumnosdto;
import com.tecnodestreza.siga.models.dto.PersonaDocumentodto;
import com.tecnodestreza.siga.services.IAlumnoService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = {"*"})
public class AlumnoController {
    private final IAlumnoService alumnoservice;

    //CONSULTA LA LISTA COMPLETA DE ALUMNOS ACTIVOS
    @GetMapping(path = "/listado")
    public ResponseEntity<List<ListadoAlumnosdto>> listado() {
        List<Alumno> alumnos=alumnoservice.consultarAlumnos();
        List<ListadoAlumnosdto> listado=alumnos.stream().map(alumno ->
                new ModelMapper().map(alumno,ListadoAlumnosdto.class)
        ).collect(Collectors.toList());
        return ResponseEntity.ok().body(listado);
    }
    //CONSULTA POR CEDULA
    @GetMapping(path = "/consultarporcedula",
            produces = "application/json")
    public ResponseEntity<Optional<Alumno>> consultarporcedula(@RequestBody PersonaDocumentodto personaDocumentodto) {
        Optional<Alumno> alumno = alumnoservice.consultarAlumnoPorCedula(personaDocumentodto.getTipoDocumento(), personaDocumentodto.getNumeroDocumento());
        if (!alumno.isPresent())
            return ResponseEntity.ok(Optional.empty());
         else
            return ResponseEntity.ok().body(alumno);
    }

    @GetMapping(path = "/consultarporid/{id}",
            produces = "application/json")
    public ResponseEntity<Optional<Alumno>> consultarporid(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoservice.consultarAlumnoPorId(id);
        if (!alumno.isPresent())
            return ResponseEntity.ok(Optional.empty());
        else
            return ResponseEntity.ok().body(alumno);
    }

   //CREAR
    //@PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PostMapping("crear")
    public ResponseEntity<Optional<Alumno>> crear(@RequestBody Alumnodto alumnodto) {
        ModelMapper modelMapper=new ModelMapper();
        Alumno alumno=modelMapper.map(alumnodto,Alumno.class);
        Optional<Alumno> optionalAlumno=alumnoservice.consultarAlumnoPorCedula(alumno.getTipoDocumento(),alumno.getNumeroDocumento());
        if(optionalAlumno.isPresent()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoservice.guardarAlumno(alumno,null));
    }
    //MODIFICAR
   // @PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PutMapping("modificar/{idAlumno}")
    public ResponseEntity<Optional<Alumno>> modificar(@RequestBody Alumnodto alumnodto, @PathVariable Long idAlumno) {
        ModelMapper modelMapper=new ModelMapper();
        Alumno alumno=modelMapper.map(alumnodto,Alumno.class);
        return ResponseEntity.status(HttpStatus.OK).body(alumnoservice.guardarAlumno(alumno,idAlumno));
    }
    //DESACTIVAR
   // @PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PutMapping("desactivar/{idAlumno}/{condicion}")
    public ResponseEntity<Optional<Alumno>> desactivar(@PathVariable Long idAlumno,@PathVariable String condicion) {
        alumnoservice.desactivar(idAlumno,condicion);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/consultaralumnosporcurso")
    public ResponseEntity<List<Alumno>> consultaralumnosporcurso(@RequestParam Long idcurso) {
            List<Alumno> alumnos=alumnoservice.alumnosPorCurso(idcurso);
            if (!alumnos.isEmpty()){
                return ResponseEntity.status(HttpStatus.OK).body(alumnos);
            }else{
                return ResponseEntity.notFound().build();
            }
    }
}
