package com.tecnodestreza.siga.models.DTOS;

import com.tecnodestreza.siga.models.NotaPar;
import com.tecnodestreza.siga.repo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaParDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idNotaPar;
    private Long idAlumno;
    private Long idCurso;
    private Long idLapso;
    private Long idMat;
    private Long idPrf;
    private String tipoDeCarga;
    private Float nota;
    private Float porcentaje;
    static IAlumnoRepo alumnoRepo;
    static ICursoRepo cursoRepo;
    static ILapsoRepo lapsoRepo;
    static IMateriaRepo materiaRepo;
    static IProfesorRepo profesorRepo;
    public static NotaPar toNotaPar(NotaParDTO notaParDTO) {

        NotaPar notaPar = new NotaPar();

        notaPar.setIdAlumno(notaParDTO.getIdAlumno());

        notaPar.setIdCurso(notaParDTO.getIdCurso());

        notaPar.setIdMat(notaParDTO.getIdMat());

        notaPar.setIdPrf(notaParDTO.getIdPrf());

        notaPar.setIdLapso(notaParDTO.getIdLapso());

        notaPar.setNota(notaParDTO.getNota());

      return notaPar;

    }
    public static List<NotaPar> getListNotasPar(List<NotaParDTO> notasParDTO) {
        List<NotaPar> notasPar = new ArrayList<>();

        for (NotaParDTO notaparDTO : notasParDTO) {
            notasPar.add(NotaParDTO.toNotaPar(notaparDTO));
        }

        return notasPar;
    }
}
