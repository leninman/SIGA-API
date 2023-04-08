/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.controllers;
import com.tecnodestreza.siga.models.*;
import com.tecnodestreza.siga.services.ICursoService;
import com.tecnodestreza.siga.services.IAlumnoService;
import com.tecnodestreza.siga.services.IRepresentanteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author Personal
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = {"direccionbase"})
public class AlumnoController {
    private final IAlumnoService alumnoservice;
    private final IRepresentanteService representanteservice;
    ICursoService cursoservice;
    boolean modificaralumno;

    //CONSULTA LA LISTA DE ALUMNOS ACTIVOS
    @GetMapping(path = "/listado")
    public ResponseEntity<?> consultaralumnos() {
        List<Alumno> alumnos=alumnoservice.consultarAlumnos();
        return ResponseEntity.ok().body(alumnos);
    }
    //CONSULTA DE ALUMNO POR CEDULA
    @GetMapping(path = "/consultarporcedula",
            produces = "application/json")
    public ResponseEntity<?> consultaAlumno(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return ResponseEntity.ok().body(alumnoservice.consultarAlumnoPorCedula(tdoc,ndoc));
    }
   //GUARDAR ALUMNO
    @PostMapping("crear")
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
        modificaralumno=false;
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoservice.crearAlumno(alumno,modificaralumno));
    }
    //MODIFICAR ALUMNO
    @PutMapping("modificar/{idAlumno}")
    public ResponseEntity<?> modificar(@RequestBody Alumno alumno,@PathVariable Long idAlumno) {
        modificaralumno=true;
        return ResponseEntity.status(HttpStatus.OK).body(alumnoservice.modificarAlumno(alumno,idAlumno,modificaralumno));
    }


}
