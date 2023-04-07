/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models.DTOS;

/**
 *
 * @author Lenin
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCursoDTO implements Serializable {
    private Long IdAl;
    private String tipoDocAl;
    private String numDocAl;
    private String primNombAl;
    private String segNombAl;
    private String primApellAl;
    private String segApellAl;
    private String annio;
    private String seccion;
}
