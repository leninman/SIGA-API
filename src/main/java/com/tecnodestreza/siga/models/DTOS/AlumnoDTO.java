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
import org.springframework.format.annotation.DateTimeFormat;
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
public class AlumnoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAl;
	private String tipoDocAl;
	private String numDocAl;
	private String primNombAl;
	private String segNombAl;
	private String primApellAl;
	private String segApellAl;
	private String sexoAl;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechNacAl;
	private String edadAl;
	private String textoDirPpalAl;
	private String estadodirppalest;
	private String municipiodirppalest;
	private String ciudaddirppalest;
	private String parroquiadirppalest;
	private String codpostaldirppalest;
	private String textoDirSecAl;
	private String estadodirsecest;
	private String municipiodirsecest;
	private String ciudaddirsecest;
	private String parroquiadirsecest;
	private String codpostaldirsecest;
	private String codoperadorappalest;
	private String textoTlfPpalAl;
	private String codoperadorasecest;
	private String textoTlfSecAl;
	private String emailAl;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechIngAl;
	private String status;
	private String tipoDocRep1;
	private String numDocRep1;
	private String primNombRpr1;
	private String segNombRpr1;
	private String primApellRpr1;
	private String segApellRpr1;
	private String sexoRpr1;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechNacRpr1;
	private String edadRpr1;
	private String edoCivRpr1;
	private String parRpr1;
	private String textoDirPpalRpr1;
	private String estadodirppalrep1;
	private String municipiodirppalrep1;
	private String ciudaddirppalrep1;
	private String parroquiadirppalrep1;
	private String codpostaldirppalrep1;
	private String textoDirSecRpr1;
	private String estadodirsecrep1;
	private String municipiodirsecrep1;
	private String ciudaddirsecrep1;
	private String parroquiadirsecrep1;
	private String codpostaldirsecrep1;
	private String codoperadorappalrep1;
	private String textoTlfPpalRpr1;
	private String emailRpr1;
	private String codoperadorasecrep1;
	private String textoTlfSecRpr1;
	private String tipoDocRep2;
	private String numDocRep2;
	private String primNombRpr2;
	private String segNombRpr2;
	private String primApellRpr2;
	private String segApellRpr2;
	private String sexoRpr2;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechNacRpr2;
	private String edadRpr2;
	private String edoCivRpr2;
	private String parRpr2;
	private String textoDirPpalRpr2;
	private String estadodirppalrep2;
	private String municipiodirppalrep2;
	private String ciudaddirppalrep2;
	private String parroquiadirppalrep2;
	private String codpostaldirppalrep2;
	private String textoDirSecRpr2;
	private String estadodirsecrep2;
	private String municipiodirsecrep2;
	private String ciudaddirsecrep2;
	private String parroquiadirsecrep2;
	private String codpostaldirsecrep2;

	private String codoperadorappalrep2;
	private String textoTlfPpalRpr2;
	private String codoperadorasecrep2;
	private String textoTlfSecRpr2;
	private String emailRpr2;
	private Long idRpr1;
	private Long idCurso;
	private Long idRpr2;
	private Date fechaCreacion;
	private String annio;
	private String annioescolar;
	private String seccion;
	private String nivel;
	private String turno;
	private String especialidad;
}
