package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaConsultadto {
    private String materia;
    private String nota;
    private String lapso;
    private String porcentaje;
}
