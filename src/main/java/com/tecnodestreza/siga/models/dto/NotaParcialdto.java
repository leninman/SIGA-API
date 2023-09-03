package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaParcialdto {
    private Long alumnoId;
    private Long docenteId;
    private Long cursoId;
    private Long materiaId;
    private String lapso;
    private String nota;
    private String porcentaje;
}
