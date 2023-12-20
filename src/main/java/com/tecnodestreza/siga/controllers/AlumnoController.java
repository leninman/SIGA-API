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

import java.util.*;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = {"*"})
@Slf4j
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
    public ResponseEntity<?> consultarporcedula(@Valid @RequestBody PersonaDocumentodto personaDocumentodto, BindingResult result) {
        Map<String,Object> responses=new HashMap<>();
        if(result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream().map(e->"El campo ".concat(e.getField()).concat(" ").concat(e.getDefaultMessage()).concat(" ")).collect(Collectors.toList());
            errors.stream().forEach(error->{
                responses.put("mensaje",error);
                log.error(error);
            });
            return new ResponseEntity<>(responses,HttpStatus.BAD_REQUEST);

        }
        try {
            Optional<Alumno> alumno = alumnoservice.consultarAlumnoPorCedula(personaDocumentodto.getTipoDocumento(), personaDocumentodto.getNumeroDocumento());
            if (!alumno.isPresent()) {
                responses.put("mensaje", "El alumno con el número de cédula ".concat(personaDocumentodto.getTipoDocumento().concat(personaDocumentodto.getNumeroDocumento())).concat(" no está registrado"));
                log.error("El alumno con el número de cédula {}{} no esta registrado",personaDocumentodto.getTipoDocumento(),personaDocumentodto.getNumeroDocumento());
                return new ResponseEntity<>(responses, HttpStatus.NOT_FOUND);
            } else {
                return ResponseEntity.ok().body(alumno);
            }
        }catch (DataAccessException e){
            responses.put("mensaje","Error al realizar la consulta a la base de datos:");
            responses.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(responses, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/consultarporid/{id}",
            produces = "application/json")
    public ResponseEntity<Optional<Alumno>> consultarporid(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoservice.consultarAlumnoPorId(id);
        if (!alumno.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return ResponseEntity.ok().body(alumno);
    }

   //CREAR
    //@PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PostMapping("crear")
    public ResponseEntity<?> crear(@Valid @RequestBody Alumnodto alumnodto,BindingResult result) {
        Map<String,Object> responses=new HashMap<>();
        if(result.hasErrors()){
            List<String> errors=result.getFieldErrors().stream().map(error->"Error con el campo ".concat(error.getField()).concat(" ").concat(error.getDefaultMessage()).concat(" ")).collect(Collectors.toList());
            errors.stream().forEach(error->{
                responses.put("mensaje",error);
                log.error(error);
            });
            return new ResponseEntity<>(responses,HttpStatus.BAD_REQUEST);
        }

        ModelMapper modelMapper=new ModelMapper();
        Alumno alumno=modelMapper.map(alumnodto,Alumno.class);
        Optional<Alumno> optionalAlumno=alumnoservice.consultarAlumnoPorCedula(alumno.getTipoDocumento(),alumno.getNumeroDocumento());
        if(optionalAlumno.isPresent()){
            responses.put("mensaje","El alumno con cedula ".concat(alumno.getTipoDocumento().concat(alumno.getNumeroDocumento())).concat(" ya esta registrado"));
            return new ResponseEntity<>(responses,HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoservice.guardarAlumno(alumno,null));
    }
    //MODIFICAR
   // @PreAuthorize("hasRole('DIRECTOR') || hasRole('ADMINISTRATIVO')")
    @PutMapping("modificar/{idAlumno}")
    public ResponseEntity<Optional<Alumno>> modificar(@RequestBody Alumnodto alumnodto, @PathVariable Long idAlumno) {
        ModelMapper modelMapper=new ModelMapper();
        Alumno alumno=modelMapper.map(alumnodto,Alumno.class);
        Optional<Alumno> optionalAlumno=alumnoservice.consultarAlumnoPorCedula(alumno.getTipoDocumento(),alumno.getNumeroDocumento());
        if(optionalAlumno.isPresent()&&idAlumno!=optionalAlumno.get().getId()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
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
