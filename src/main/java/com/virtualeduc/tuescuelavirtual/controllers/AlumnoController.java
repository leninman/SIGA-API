/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;
import com.virtualeduc.tuescuelavirtual.models.*;
import com.virtualeduc.tuescuelavirtual.models.DTOS.*;
import com.virtualeduc.tuescuelavirtual.models.mappers.AlumnoDtoToAlumnoCursoDto;
import com.virtualeduc.tuescuelavirtual.models.mappers.AlumnoToAlumnoDtoMapper;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IMateriaService;
import com.virtualeduc.tuescuelavirtual.services.INotasService;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.services.IUsuarioService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
/**
 *
 * @author Personal
 */
@RestController
public class AlumnoController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IProfesoresService profesorservice;

    @Autowired
    IRepresentanteService representanteservice;

    @Autowired
    IMateriaService materiaservice;

    @Autowired
    IUsuarioService usuarioservice;

    @Autowired
    INotasService notasservice;

    @Autowired
    INotasService notasService;

    @Value("${dir.base}")
    String direccionbase;

    @Autowired
    ICursoService cursoservice;

    @Autowired
    INotasService notaservice;

    Representante representante;

    Boolean guardarAlumno;
    boolean guardar;

    boolean guardarCurso;

    List<AlumnoDTO> lista = new ArrayList<>();

    List<NotaWrapper> notasresultado;

    //CONSULTA LA LISTA DE ALUMNOS ACTIVOS
    @CrossOrigin(origins = {"direccionbase/consultaralumnos"})
    @GetMapping(path = "/consultaralumnos")
    public ResponseEntity<?> consultaralumnos() {
        List<AlumnoDTO> alumnosDTO=alumnoservice.consultarAlumnos();
        List<AlumnoCursoDTO> alumnoCursoDTOS=alumnosDTO.stream().map(AlumnoDTO->
                new AlumnoDtoToAlumnoCursoDto().apply(AlumnoDTO)).collect(Collectors.toList());
        return ResponseEntity.ok(alumnoCursoDTOS);
    }

    //CONSULTA DE ALUMNO POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultaAlumno"})
    @GetMapping(path = "/consultaAlumno",
            produces = "application/json")
    public ResponseEntity<?> consultaAlumno(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return ResponseEntity.ok(new AlumnoToAlumnoDtoMapper().apply(this.alumnoservice.consultarAlumnoPorCedula(tdoc, ndoc)));
    }


   //REGISTRAR UN NUEVO ALUMNO
   @CrossOrigin(origins = {"direccionbase/agregaralumno"})
    @PostMapping(path = "/agregaralumno")
    public ResponseEntity<?> agregaralumno(@RequestBody AlumnoDTO alumnoDTO) {
        Responses resp = alumnoservice.guardaAlumno(alumnoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }



    //MODIFICA UN ALUMNO YA EXISTENTE
   /* @PostMapping(path = "/modificaralumno")
    public ResponseEntity<?> modificaralumno(@RequestBody AlumnoDTO alumnoDTO) {



        // cedula no existe
        guardar = false;

        Responses resp;

        Representante rep1;

        Representante rep2;

        String tipoDocRpr;

        String numDocRpr;

        Alumno alumnoguardado = alumnoservice.consultarAlumnoPorId(alumnoDTO.getIdAl());

        Alumno alumnoActualizar = new Alumno(alumnoDTO);

        alumnoActualizar.setIdAl(alumnoguardado.getIdAl());

        if (alumnoguardado.getIdAl() != null) {
            alumnoActualizar.setFechaCreacion(alumnoguardado.getFechaCreacion());
        }

        Curso curso = new Curso();

        AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(), alumnoDTO.getEspecialidad());

        AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolar();

        SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());

        CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(),
                annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());

        Annio annio = new Annio(annioDTO);

        AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);

        Seccion seccion = new Seccion(seccionDTO);

        curso.setIdAnnio(annio);

        curso.setIdAnnioEsc(annioescolar);

        curso.setIdSec(seccion);

        curso.setIdCurso(cursoDTO.getIdCurso());

        alumnoActualizar.setIdCurso(curso);

        if (alumnoDTO.getTipoDocRep1() != null && alumnoDTO.getNumDocRep1() != null) {
            tipoDocRpr = alumnoDTO.getTipoDocRep1();

            numDocRpr = alumnoDTO.getNumDocRep1();

            rep1 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
        } else {
            rep1 = alumnoguardado.getIdRpr1();
        }

        alumnoActualizar.setIdRpr1(rep1);

        if (alumnoDTO.getTipoDocRep2() != null && alumnoDTO.getNumDocRep2() != null) {

            tipoDocRpr = alumnoDTO.getTipoDocRep2();

            numDocRpr = alumnoDTO.getNumDocRep2();



            rep2 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
        } else {
            rep2 = alumnoguardado.getIdRpr2();
        }

        alumnoActualizar.setIdRpr2(rep2);

        resp = alumnoservice.guardaAlumno(alumnoActualizar, guardar);


        return ResponseEntity.status(HttpStatus.CREATED).body(resp);

    }*/





    //CONSULTA DE REPRESENTANTE POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultarepresentante"})
    @GetMapping(path = "/consultarepresentante",
            produces = "application/json")
    public @ResponseBody
    RepresentanteDTO consultarepresentante(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return representanteservice.obtenerRepresentantePorCedula(tdoc, ndoc);
    }


    //CONSULTA DE PROFESOR POR CEDULA
    @CrossOrigin(origins = {"direccionbase/buscarProfesor"})
    @GetMapping(path = "/buscarProfesor",
            produces = "application/json")
    public @ResponseBody
    ProfesorDTO consultaProfesor(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        ProfesorDTO profesorDTO;
        Profesor profesor = this.profesorservice.consultarProfesorPorCedula(tdoc, ndoc);
        profesorDTO = new ProfesorDTO(profesor);
        return profesorDTO;
    }

    //CONSULTA LA LISTA DE CURSOS DEL PERIODO ACUAL VIGENTE QUE ESTE ACTIVO
    @CrossOrigin(origins = {"direccionbase/consultarcursosporperiodo"})
    @GetMapping(path = "/consultarcursosporperiodo",
            produces = "application/json")
    public @ResponseBody
    List<CursoDTO> consultarlistacursosporperiodo() {

        AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();

        return cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
    }

    //CONSULTA CURSO POR ID DEL CURSO
    @CrossOrigin(origins = {"direccionbase/consultarcursoporid"})
    @GetMapping(path = "/consultarcursoporid")
    public CursoDTO consultarcursoporid(@RequestParam(name = "idcurso") Long idcurso) {

        return cursoservice.consultarCursoPorId(idcurso);
    }

    //PARA ACTUALIZAR LOS ID DE CURSO DE LOS ALUMNOS
   /* @CrossOrigin(origins = {"direccionbase/actualizaridalumnos"})
    @PostMapping(path = "/actualizaridalumnos")
    public Responses actualizarIdAlumnos(@RequestParam(name = "idcurso") Long idcurso,
                                         @RequestParam(name = "cedulasAlumnos[]") String[] cedulasAlumnos,
                                         RedirectAttributes redirectAttributes) {

        Responses resp = new Responses();

        String[] cedulas = cedulasAlumnos;

        guardarAlumno = false;   //Falso porque vamos a actualizar el registro

        Curso curso = this.cursoservice.consultarCursoPorIdCurso(idcurso);

        for (int i = 0; i < cedulas.length; i++) {

            String cedula = cedulas[i];

            String tipoDoc = cedula.substring(0, 1);

            String numDoc = cedula.substring(1);

            Alumno alumnoguardado = this.alumnoservice.consultarAlumnoPorCedula(tipoDoc, numDoc);

            Alumno alumnoaguardar = new Alumno();

            alumnoaguardar = alumnoguardado;

            alumnoaguardar.setIdAl(alumnoguardado.getIdAl());

            alumnoaguardar.setIdCurso(curso);

            resp = this.alumnoservice.guardaAlumno(alumnoaguardar, guardarAlumno);

        }
        resp.setResponseCode(Constantes.CURSO_ACTUALIZADO_CODE);
        resp.setResponseDescription(Constantes.CURSO_ACTUALIZADO_DESC);
        return resp;

    }*/

    @CrossOrigin(origins = {"direccionbase/validarmateria"})
    @GetMapping(path = "/validarmateria")
    public Long validarmateria(@RequestParam(name = "materia") String materia,
                               @RequestParam(name = "annio") String annio, @RequestParam(name = "nivel") String nivel,
                               @RequestParam(name = "especialidad") String especialidad) {

        return materiaservice.consultarIdMaterias(materia, annio, nivel, especialidad);

    }

    @CrossOrigin(origins = {"direccionbase/asignarmateriasycursos"})
    @PostMapping(path = "/asignarmateriasycursos")
    public Responses asignarmateriasycursos(@RequestParam(name = "idcursos[]") Long[] idcursos,
                                            @RequestParam(name = "idmaterias[]") Long[] idmaterias, @RequestParam(name = "idprofesor") Long idprofesor,
                                            RedirectAttributes redirectAttributes) {

        Responses resp = new Responses();

        List<CursoProf> cursosprof = new ArrayList<>();

        for (int i = 0; i < idmaterias.length; i++) {

            CursoProf cursoprof = new CursoProf();

            cursoprof.setIdCurso(idcursos[i]);

            cursoprof.setIdMat(idmaterias[i]);

            cursoprof.setIdProf(idprofesor);

            cursosprof.add(cursoprof);

        }

        resp = cursoservice.asignarCursosMaterias(cursosprof);

        return resp;

    }

    @CrossOrigin(origins = {"direccionbase/guardarnotas"})
    @PostMapping(path = "/guardarnotas", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Responses guardarnotas(@RequestBody List<NotaParDTO> calificaciones,
                           RedirectAttributes redirectAttributes) {

        return notasservice.guardarNotasParciales(calificaciones);

    }

    @CrossOrigin(origins = {"direccionbase/obtenerNotas"})
    @GetMapping(path = "/obtenerNotas")
    public List<NotaWrapper> obtenerNotas(@RequestParam(name = "cedula") String cedula,
                                          String periodo, String lapso, String tipodeconsulta, Model model) {

        String tipoDoc = cedula.substring(0, 1);
        String numDoc = cedula.substring(1);
        Responses response = new Responses();

        notasresultado = new ArrayList<>();

        if (tipodeconsulta.equalsIgnoreCase("Parciales")) {

            notasresultado = notaservice.consultarNotasPorCedulaPeriodoYlapso(tipoDoc, numDoc, periodo, lapso);

            if (!notasresultado.isEmpty()) {
                response.setNotasWrapper(notasresultado);
                response.setResponseCode(Constantes.CONSULTA_EXITOSA_DE_NOTAS);
                response.setResponseDescription(Constantes.CONSULTA_EXITOSA_DE_NOTAS_DESC);
            }else{
                notasresultado=null;
                response.setNotasWrapper(null);
                response.setResponseCode(Constantes.PERIODO_LAPSO_SIN_REGISTROS_DE_NOTAS);
                response.setResponseDescription(Constantes.PERIODO_LAPSO_SIN_REGISTROS_DE_NOTAS_DESC);

            }

        }

        if (tipodeconsulta.equalsIgnoreCase("Definitivas")) {
            notasresultado=null;
        }

        return notasresultado;

    }
    @CrossOrigin(origins = {"direccionbase/actualizarNota"})
    @PostMapping(path = "/actualizarNota",produces = "application/json")
    public @ResponseBody Responses actualizarNota(@RequestParam(name="idAlumno") Long idAlumno,
                                                  @RequestParam(name="idMateria") Long idMateria,
                                                  @RequestParam(name="idCurso") Long idCurso,
                                                  @RequestParam(name="notaLapso1", required=false) Float notaLapso1,
                                                  @RequestParam(name="notaLapso2",required=false) Float notaLapso2,
                                                  @RequestParam(name="notaLapso3",required=false) Float notaLapso3){
        return notaservice.actualizarNotasParciales(idAlumno,idMateria,idCurso,notaLapso1,notaLapso2,notaLapso3);

    }

    @CrossOrigin(origins = {"direccionbase/crearCurso"})
    @PostMapping(path = "/crearCurso",consumes= "application/json",produces = "application/json")
    public @ResponseBody Responses crearCurso(CursoDTO cursoDTO,BindingResult result){


        guardarCurso = true;
        Responses resp = new Responses();


        if (cursoservice.cursoporcurso(cursoDTO) != null) {
            resp.setResponseCode(Constantes.CURSO_EXISTE_CODE);
            resp.setResponseDescription(Constantes.CURSO_EXISTE_DESC);

        }else{
            resp = cursoservice.guardarCurso(cursoDTO, guardarCurso);
        }

        return resp;
    }

}
