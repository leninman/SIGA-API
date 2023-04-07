/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models.DTOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnioEscolarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
    private Long idAnnioEsc;
    private String intAnnioEsc;
    private Date FechaI;
    private Date FechaF;
    private String status;
}
