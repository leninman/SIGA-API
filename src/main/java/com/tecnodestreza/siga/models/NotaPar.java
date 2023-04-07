package com.tecnodestreza.siga.models;

import com.tecnodestreza.siga.models.DTOS.NotaParDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the notas_par database table.
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notas_par")
public class NotaPar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTA_PAR")
    private Long idNotaPar;
    @Column(name = "ID_ALUMNO")
    private Long idAlumno;
    @Column(name = "ID_CURSO")
    private Long idCurso;
    @Column(name = "ID_LAPSO")
    private Long idLapso;
    @Column(name = "ID_MAT")
    private Long idMat;
    @Column(name = "ID_PRF")
    private Long idPrf;
    private Float nota;
    private Float porcentaje;
    public static NotaParDTO toNotaParDTO(NotaPar notaPar) {
        NotaParDTO notaParDTO = new NotaParDTO();
        notaParDTO.setIdAlumno(notaPar.getIdAlumno());
        notaParDTO.setIdCurso(notaPar.getIdCurso());
        notaParDTO.setIdLapso(notaPar.getIdLapso());
        notaParDTO.setIdMat(notaPar.getIdMat());
        notaParDTO.setIdPrf(notaPar.getIdPrf());
        notaParDTO.setIdNotaPar(notaPar.getIdNotaPar());
        return notaParDTO;
    }
    public List<NotaParDTO> getListNotasParDTO(List<NotaPar> notasPar) {
        List<NotaParDTO> notasPardto = new ArrayList<>();
        for (NotaPar notapar : notasPar) {
            notasPardto.add(NotaPar.toNotaParDTO(notapar));
        }
        return notasPardto;
    }
}
