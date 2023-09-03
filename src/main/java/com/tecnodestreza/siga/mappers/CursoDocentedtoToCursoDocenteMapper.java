package com.tecnodestreza.siga.mappers;

import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.CursoDocente;
import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.Materia;
import com.tecnodestreza.siga.models.dto.CursoDocentedto;
import com.tecnodestreza.siga.services.ICursoService;
import com.tecnodestreza.siga.services.IDocenteService;
import com.tecnodestreza.siga.services.IMateriaService;

import java.util.Optional;
import java.util.function.Function;


public class CursoDocentedtoToCursoDocenteMapper implements Function<CursoDocentedto, CursoDocente> {


    private final IMateriaService materiaService;
    private final IDocenteService docenteService;
    private final ICursoService cursoService;

    public CursoDocentedtoToCursoDocenteMapper(IMateriaService materiaService, IDocenteService docenteService, ICursoService cursoService) {
        this.materiaService = materiaService;
        this.docenteService = docenteService;
        this.cursoService = cursoService;
    }

    @Override
    public CursoDocente apply(CursoDocentedto cursoDocentedto) {
        CursoDocente cursoDocente=new CursoDocente();
        Optional<Curso> curso=cursoService.consultarCursoPorId(cursoDocentedto.getCursoId());
        Optional<Docente> docente=docenteService.consultarDocentePorId(cursoDocentedto.getDocenteId());
        Optional<Materia> materia=materiaService.consultarMateriaPorId(cursoDocentedto.getMateriaId());
        if(curso.isPresent()) {
            cursoDocente.setCurso(curso.get());
        }
        if(docente.isPresent()) {
            cursoDocente.setDocente(docente.get());
        }
        if(materia.isPresent()) {
            cursoDocente.setMateria(materia.get());
        }
        return cursoDocente;
    }
}
