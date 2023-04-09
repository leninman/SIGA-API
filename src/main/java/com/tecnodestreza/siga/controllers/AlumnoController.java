/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.controllers;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.services.IAlumnoService;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Lenin
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = {"direccionbase"})
public class AlumnoController {
    private final IAlumnoService alumnoservice;

    //CONSULTA LA LISTA COMPLETA DE ALUMNOS ACTIVOS
    @GetMapping(path = "/listado")
    public ResponseEntity<?> listado() {
        List<Alumno> alumnos=alumnoservice.consultarAlumnos();
        return ResponseEntity.ok().body(alumnos);
    }
    //CONSULTA POR CEDULA
    @GetMapping(path = "/consultarporcedula",
            produces = "application/json")
    public ResponseEntity<?> consultarporcedula(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return ResponseEntity.ok().body(alumnoservice.consultarAlumnoPorCedula(tdoc,ndoc));
    }
   //CREAR
    @PostMapping("crear")
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        Optional<Alumno> optionalAlumno=alumnoservice.consultarAlumnoPorCedula(alumno.getTipoDocumento(),alumno.getNumeroDocumento());
        if(optionalAlumno.isPresent()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoservice.guardarAlumno(alumno,null));
    }
    //MODIFICAR
    @PutMapping("modificar/{idAlumno}")
    public ResponseEntity<?> modificar(@RequestBody Alumno alumno,@PathVariable Long idAlumno) {
        return ResponseEntity.status(HttpStatus.OK).body(alumnoservice.guardarAlumno(alumno,idAlumno));
    }


}
