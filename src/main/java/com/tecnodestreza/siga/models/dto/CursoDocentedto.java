package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDocentedto {
    private Long cursoId;
    private Long materiaId;
    private Long docenteId;
}
