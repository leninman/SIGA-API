/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models.DTOS;

import com.tecnodestreza.siga.models.Representante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepresentanteDTO implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idRpr;
    private String tipoDocRpr;
    private String numDocRpr;
    private String primNombRpr;
    private String segNombRpr;
    private String primApellRpr;
    private String segApellRpr;
    private String sexoRpr;
    private Date fechNacRpr;
    private String edadRpr;
    private String edoCivRpr;
    private String textoDirPpalRpr;
    private String estadodirppalrep;
    private String municipiodirppalrep;
    private String ciudaddirppalrep;
    private String parroquiadirppalrep;
    private String codpostaldirppalrep;
    private String textoDirSecRpr;
    private String estadodirsecrep;
    private String municipiodirsecrep;
    private String ciudaddirsecrep;
    private String parroquiadirsecrep;
    private String codpostaldirsecrep;
    private String codoperadorappalrep;
    private String textoTlfPpalRpr;
    private String codoperadorasecrep;
    private String textoTlfSecRpr;
    private String emailRpr;
       public RepresentanteDTO(Representante representante){
        String strDirPpalRpr=representante.getDirPpalRpr();
   		String[] arrOfStrDirPpalRpr=strDirPpalRpr.split(",");
   		String strDirSecRpr=representante.getDirSecRpr();
   		String[] arrOfStrDirSecRpr=strDirSecRpr.split(",");
   		String strTlfPpalRpr=representante.getTlfPpalRpr();
   		String[] arrOfStrTlfPpalRpr=strTlfPpalRpr.split("-");
   		String strTlfSecRpr=representante.getTlfSecRpr();
   		String[] arrOfStrTlfSecRpr=strTlfSecRpr.split("-");
        this.idRpr=representante.getIdRpr();
        this.tipoDocRpr = representante.getTipoDocRpr();
        this.numDocRpr = representante.getNumDocRpr();
        this.primNombRpr = representante.getPrimNombRpr();
        this.segNombRpr = representante.getSegNombRpr();
        this.primApellRpr = representante.getPrimApellRpr();
        this.segApellRpr = representante.getSegApellRpr();
        this.sexoRpr = representante.getSexoRpr();
        this.fechNacRpr = representante.getFechNacRpr();
        this.edadRpr = representante.getEdadRpr();
        this.edoCivRpr = representante.getEdoCivRpr();
        this.textoDirPpalRpr=arrOfStrDirPpalRpr[0];
        this.estadodirppalrep=arrOfStrDirPpalRpr[1];
        this.municipiodirppalrep=arrOfStrDirPpalRpr[2];
        this.ciudaddirppalrep=arrOfStrDirPpalRpr[3];
        this.parroquiadirppalrep=arrOfStrDirPpalRpr[4];
        this.codpostaldirppalrep=arrOfStrDirPpalRpr[5];
        this.textoDirSecRpr=arrOfStrDirSecRpr[0];
        this.estadodirsecrep=arrOfStrDirSecRpr[1];
        this.municipiodirsecrep=arrOfStrDirSecRpr[2];
        this.ciudaddirsecrep=arrOfStrDirSecRpr[3];
        this.parroquiadirsecrep=arrOfStrDirSecRpr[4];
        this.codpostaldirsecrep=arrOfStrDirSecRpr[5];
        this.codoperadorappalrep=arrOfStrTlfPpalRpr[0];
        this.textoTlfPpalRpr=arrOfStrTlfPpalRpr[1];
        this.codoperadorasecrep=arrOfStrTlfSecRpr[0];
        this.textoTlfSecRpr=arrOfStrTlfSecRpr[1];
        this.emailRpr = representante.getEmailRpr();
       }
}
