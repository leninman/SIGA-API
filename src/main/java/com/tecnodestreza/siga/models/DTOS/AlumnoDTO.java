/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models.DTOS;

import com.tecnodestreza.siga.models.Alumno;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lenin
 */
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

//    @PrePersist
//    public void prePersist() {
//        fechaCreacion = new Date();
//
//    }
	public AlumnoDTO() {
	}

	public AlumnoDTO(Long idAl) {
		this.idAl = idAl;
	}



	public AlumnoDTO(Alumno alumno) {

	}

	public Long getIdAl() {
		return idAl;
	}

	public void setIdAl(Long idAl) {
		this.idAl = idAl;
	}

	public String getTipoDocAl() {
		return tipoDocAl;
	}

	public void setTipoDocAl(String tipoDocAl) {
		this.tipoDocAl = tipoDocAl;
	}

	public String getNumDocAl() {
		return numDocAl;
	}

	public void setNumDocAl(String numDocAl) {
		this.numDocAl = numDocAl;
	}

	public String getPrimNombAl() {
		return primNombAl;
	}

	public void setPrimNombAl(String primNombAl) {
		this.primNombAl = primNombAl;
	}

	public String getSegNombAl() {
		return segNombAl;
	}

	public void setSegNombAl(String segNombAl) {
		this.segNombAl = segNombAl;
	}

	public String getPrimApellAl() {
		return primApellAl;
	}

	public void setPrimApellAl(String primApellAl) {
		this.primApellAl = primApellAl;
	}

	public String getSegApellAl() {
		return segApellAl;
	}

	public void setSegApellAl(String segApellAl) {
		this.segApellAl = segApellAl;
	}

	public String getSexoAl() {
		return sexoAl;
	}

	public void setSexoAl(String sexoAl) {
		this.sexoAl = sexoAl;
	}

	public Date getFechNacAl() {
		return fechNacAl;
	}

	public void setFechNacAl(Date fechNacAl) {
		this.fechNacAl = fechNacAl;
	}

	public String getEdadAl() {
		return edadAl;
	}

	public void setEdadAl(String edadAl) {
		this.edadAl = edadAl;
	}

	public String getTextoDirPpalAl() {
		return textoDirPpalAl;
	}

	public void setTextoDirPpalAl(String textoDirPpalAl) {
		this.textoDirPpalAl = textoDirPpalAl;
	}

	public String getEstadodirppalest() {
		return estadodirppalest;
	}

	public void setEstadodirppalest(String estadodirppalest) {
		this.estadodirppalest = estadodirppalest;
	}

	public String getMunicipiodirppalest() {
		return municipiodirppalest;
	}

	public void setMunicipiodirppalest(String municipiodirppalest) {
		this.municipiodirppalest = municipiodirppalest;
	}

	public String getCiudaddirppalest() {
		return ciudaddirppalest;
	}

	public void setCiudaddirppalest(String ciudaddirppalest) {
		this.ciudaddirppalest = ciudaddirppalest;
	}

	public String getParroquiadirppalest() {
		return parroquiadirppalest;
	}

	public void setParroquiadirppalest(String parroquiadirppalest) {
		this.parroquiadirppalest = parroquiadirppalest;
	}

	public String getCodpostaldirppalest() {
		return codpostaldirppalest;
	}

	public void setCodpostaldirppalest(String codpostaldirppalest) {
		this.codpostaldirppalest = codpostaldirppalest;
	}

	public String getTextoDirSecAl() {
		return textoDirSecAl;
	}

	public void setTextoDirSecAl(String textoDirSecAl) {
		this.textoDirSecAl = textoDirSecAl;
	}

	public String getEstadodirsecest() {
		return estadodirsecest;
	}

	public void setEstadodirsecest(String estadodirsecest) {
		this.estadodirsecest = estadodirsecest;
	}

	public String getMunicipiodirsecest() {
		return municipiodirsecest;
	}

	public void setMunicipiodirsecest(String municipiodirsecest) {
		this.municipiodirsecest = municipiodirsecest;
	}

	public String getCiudaddirsecest() {
		return ciudaddirsecest;
	}

	public void setCiudaddirsecest(String ciudaddirsecest) {
		this.ciudaddirsecest = ciudaddirsecest;
	}

	public String getParroquiadirsecest() {
		return parroquiadirsecest;
	}

	public void setParroquiadirsecest(String parroquiadirsecest) {
		this.parroquiadirsecest = parroquiadirsecest;
	}

	public String getCodpostaldirsecest() {
		return codpostaldirsecest;
	}

	public void setCodpostaldirsecest(String codpostaldirsecest) {
		this.codpostaldirsecest = codpostaldirsecest;
	}

	public String getCodoperadorappalest() {
		return codoperadorappalest;
	}

	public void setCodoperadorappalest(String codoperadorappalest) {
		this.codoperadorappalest = codoperadorappalest;
	}

	public String getTextoTlfPpalAl() {
		return textoTlfPpalAl;
	}

	public void setTextoTlfPpalAl(String textoTlfPpalAl) {
		this.textoTlfPpalAl = textoTlfPpalAl;
	}

	public String getCodoperadorasecest() {
		return codoperadorasecest;
	}

	public void setCodoperadorasecest(String codoperadorasecest) {
		this.codoperadorasecest = codoperadorasecest;
	}

	public String getTextoTlfSecAl() {
		return textoTlfSecAl;
	}

	public void setTextoTlfSecAl(String textoTlfSecAl) {
		this.textoTlfSecAl = textoTlfSecAl;
	}

	public String getEmailAl() {
		return emailAl;
	}

	public void setEmailAl(String emailAl) {
		this.emailAl = emailAl;
	}

	public Date getFechIngAl() {
		return fechIngAl;
	}

	public void setFechIngAl(Date fechIngAl) {
		this.fechIngAl = fechIngAl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoDocRep1() {
		return tipoDocRep1;
	}

	public void setTipoDocRep1(String tipoDocRep1) {
		this.tipoDocRep1 = tipoDocRep1;
	}

	public String getNumDocRep1() {
		return numDocRep1;
	}

	public void setNumDocRep1(String numDocRep1) {
		this.numDocRep1 = numDocRep1;
	}

	public String getPrimNombRpr1() {
		return primNombRpr1;
	}

	public void setPrimNombRpr1(String primNombRpr1) {
		this.primNombRpr1 = primNombRpr1;
	}

	public String getSegNombRpr1() {
		return segNombRpr1;
	}

	public void setSegNombRpr1(String segNombRpr1) {
		this.segNombRpr1 = segNombRpr1;
	}

	public String getPrimApellRpr1() {
		return primApellRpr1;
	}

	public void setPrimApellRpr1(String primApellRpr1) {
		this.primApellRpr1 = primApellRpr1;
	}

	public String getSegApellRpr1() {
		return segApellRpr1;
	}

	public void setSegApellRpr1(String segApellRpr1) {
		this.segApellRpr1 = segApellRpr1;
	}

	public String getSexoRpr1() {
		return sexoRpr1;
	}

	public void setSexoRpr1(String sexoRpr1) {
		this.sexoRpr1 = sexoRpr1;
	}

	public Date getFechNacRpr1() {
		return fechNacRpr1;
	}

	public void setFechNacRpr1(Date fechNacRpr1) {
		this.fechNacRpr1 = fechNacRpr1;
	}

	public String getEdadRpr1() {
		return edadRpr1;
	}

	public void setEdadRpr1(String edadRpr1) {
		this.edadRpr1 = edadRpr1;
	}

	public String getEdoCivRpr1() {
		return edoCivRpr1;
	}

	public void setEdoCivRpr1(String edoCivRpr1) {
		this.edoCivRpr1 = edoCivRpr1;
	}

	

	public String getParRpr1() {
		return parRpr1;
	}

	public void setParRpr1(String parRpr1) {
		this.parRpr1 = parRpr1;
	}

	public String getTextoDirPpalRpr1() {
		return textoDirPpalRpr1;
	}

	public void setTextoDirPpalRpr1(String textoDirPpalRpr1) {
		this.textoDirPpalRpr1 = textoDirPpalRpr1;
	}

	public String getEstadodirppalrep1() {
		return estadodirppalrep1;
	}

	public void setEstadodirppalrep1(String estadodirppalrep1) {
		this.estadodirppalrep1 = estadodirppalrep1;
	}

	public String getMunicipiodirppalrep1() {
		return municipiodirppalrep1;
	}

	public void setMunicipiodirppalrep1(String municipiodirppalrep1) {
		this.municipiodirppalrep1 = municipiodirppalrep1;
	}

	public String getCiudaddirppalrep1() {
		return ciudaddirppalrep1;
	}

	public void setCiudaddirppalrep1(String ciudaddirppalrep1) {
		this.ciudaddirppalrep1 = ciudaddirppalrep1;
	}

	public String getParroquiadirppalrep1() {
		return parroquiadirppalrep1;
	}

	public void setParroquiadirppalrep1(String parroquiadirppalrep1) {
		this.parroquiadirppalrep1 = parroquiadirppalrep1;
	}

	public String getCodpostaldirppalrep1() {
		return codpostaldirppalrep1;
	}

	public void setCodpostaldirppalrep1(String codpostaldirppalrep1) {
		this.codpostaldirppalrep1 = codpostaldirppalrep1;
	}

	public String getTextoDirSecRpr1() {
		return textoDirSecRpr1;
	}

	public void setTextoDirSecRpr1(String textoDirSecRpr1) {
		this.textoDirSecRpr1 = textoDirSecRpr1;
	}

	public String getEstadodirsecrep1() {
		return estadodirsecrep1;
	}

	public void setEstadodirsecrep1(String estadodirsecrep1) {
		this.estadodirsecrep1 = estadodirsecrep1;
	}

	public String getMunicipiodirsecrep1() {
		return municipiodirsecrep1;
	}

	public void setMunicipiodirsecrep1(String municipiodirsecrep1) {
		this.municipiodirsecrep1 = municipiodirsecrep1;
	}

	public String getCiudaddirsecrep1() {
		return ciudaddirsecrep1;
	}

	public void setCiudaddirsecrep1(String ciudaddirsecrep1) {
		this.ciudaddirsecrep1 = ciudaddirsecrep1;
	}

	public String getParroquiadirsecrep1() {
		return parroquiadirsecrep1;
	}

	public void setParroquiadirsecrep1(String parroquiadirsecrep1) {
		this.parroquiadirsecrep1 = parroquiadirsecrep1;
	}

	public String getCodpostaldirsecrep1() {
		return codpostaldirsecrep1;
	}

	public void setCodpostaldirsecrep1(String codpostaldirsecrep1) {
		this.codpostaldirsecrep1 = codpostaldirsecrep1;
	}

	public String getCodoperadorappalrep1() {
		return codoperadorappalrep1;
	}

	public void setCodoperadorappalrep1(String codoperadorappalrep1) {
		this.codoperadorappalrep1 = codoperadorappalrep1;
	}

	public String getTextoTlfPpalRpr1() {
		return textoTlfPpalRpr1;
	}

	public void setTextoTlfPpalRpr1(String textoTlfPpalRpr1) {
		this.textoTlfPpalRpr1 = textoTlfPpalRpr1;
	}

	public String getEmailRpr1() {
		return emailRpr1;
	}

	public void setEmailRpr1(String emailRpr1) {
		this.emailRpr1 = emailRpr1;
	}

	public String getCodoperadorasecrep1() {
		return codoperadorasecrep1;
	}

	public void setCodoperadorasecrep1(String codoperadorasecrep1) {
		this.codoperadorasecrep1 = codoperadorasecrep1;
	}

	public String getTextoTlfSecRpr1() {
		return textoTlfSecRpr1;
	}

	public void setTextoTlfSecRpr1(String textoTlfSecRpr1) {
		this.textoTlfSecRpr1 = textoTlfSecRpr1;
	}

	public String getTipoDocRep2() {
		return tipoDocRep2;
	}

	public void setTipoDocRep2(String tipoDocRep2) {
		this.tipoDocRep2 = tipoDocRep2;
	}

	public String getNumDocRep2() {
		return numDocRep2;
	}

	public void setNumDocRep2(String numDocRep2) {
		this.numDocRep2 = numDocRep2;
	}

	public String getPrimNombRpr2() {
		return primNombRpr2;
	}

	public void setPrimNombRpr2(String primNombRpr2) {
		this.primNombRpr2 = primNombRpr2;
	}

	public String getSegNombRpr2() {
		return segNombRpr2;
	}

	public void setSegNombRpr2(String segNombRpr2) {
		this.segNombRpr2 = segNombRpr2;
	}

	public String getPrimApellRpr2() {
		return primApellRpr2;
	}

	public void setPrimApellRpr2(String primApellRpr2) {
		this.primApellRpr2 = primApellRpr2;
	}

	public String getSegApellRpr2() {
		return segApellRpr2;
	}

	public void setSegApellRpr2(String segApellRpr2) {
		this.segApellRpr2 = segApellRpr2;
	}

	public String getSexoRpr2() {
		return sexoRpr2;
	}

	public void setSexoRpr2(String sexoRpr2) {
		this.sexoRpr2 = sexoRpr2;
	}

	public Date getFechNacRpr2() {
		return fechNacRpr2;
	}

	public void setFechNacRpr2(Date fechNacRpr2) {
		this.fechNacRpr2 = fechNacRpr2;
	}

	public String getEdadRpr2() {
		return edadRpr2;
	}

	public void setEdadRpr2(String edadRpr2) {
		this.edadRpr2 = edadRpr2;
	}

	public String getEdoCivRpr2() {
		return edoCivRpr2;
	}

	public void setEdoCivRpr2(String edoCivRpr2) {
		this.edoCivRpr2 = edoCivRpr2;
	}

	

	public String getParRpr2() {
		return parRpr2;
	}

	public void setParRpr2(String parRpr2) {
		this.parRpr2 = parRpr2;
	}

	public String getTextoDirPpalRpr2() {
		return textoDirPpalRpr2;
	}

	public void setTextoDirPpalRpr2(String textoDirPpalRpr2) {
		this.textoDirPpalRpr2 = textoDirPpalRpr2;
	}

	public String getEstadodirppalrep2() {
		return estadodirppalrep2;
	}

	public void setEstadodirppalrep2(String estadodirppalrep2) {
		this.estadodirppalrep2 = estadodirppalrep2;
	}

	public String getMunicipiodirppalrep2() {
		return municipiodirppalrep2;
	}

	public void setMunicipiodirppalrep2(String municipiodirppalrep2) {
		this.municipiodirppalrep2 = municipiodirppalrep2;
	}

	public String getCiudaddirppalrep2() {
		return ciudaddirppalrep2;
	}

	public void setCiudaddirppalrep2(String ciudaddirppalrep2) {
		this.ciudaddirppalrep2 = ciudaddirppalrep2;
	}

	public String getParroquiadirppalrep2() {
		return parroquiadirppalrep2;
	}

	public void setParroquiadirppalrep2(String parroquiadirppalrep2) {
		this.parroquiadirppalrep2 = parroquiadirppalrep2;
	}

	public String getCodpostaldirppalrep2() {
		return codpostaldirppalrep2;
	}

	public void setCodpostaldirppalrep2(String codpostaldirppalrep2) {
		this.codpostaldirppalrep2 = codpostaldirppalrep2;
	}

	public String getTextoDirSecRpr2() {
		return textoDirSecRpr2;
	}

	public void setTextoDirSecRpr2(String textoDirSecRpr2) {
		this.textoDirSecRpr2 = textoDirSecRpr2;
	}

	public String getEstadodirsecrep2() {
		return estadodirsecrep2;
	}

	public void setEstadodirsecrep2(String estadodirsecrep2) {
		this.estadodirsecrep2 = estadodirsecrep2;
	}

	public String getMunicipiodirsecrep2() {
		return municipiodirsecrep2;
	}

	public void setMunicipiodirsecrep2(String municipiodirsecrep2) {
		this.municipiodirsecrep2 = municipiodirsecrep2;
	}

	public String getCiudaddirsecrep2() {
		return ciudaddirsecrep2;
	}

	public void setCiudaddirsecrep2(String ciudaddirsecrep2) {
		this.ciudaddirsecrep2 = ciudaddirsecrep2;
	}

	public String getParroquiadirsecrep2() {
		return parroquiadirsecrep2;
	}

	public void setParroquiadirsecrep2(String parroquiadirsecrep2) {
		this.parroquiadirsecrep2 = parroquiadirsecrep2;
	}

	public String getCodpostaldirsecrep2() {
		return codpostaldirsecrep2;
	}

	public void setCodpostaldirsecrep2(String codpostaldirsecrep2) {
		this.codpostaldirsecrep2 = codpostaldirsecrep2;
	}

	public String getCodoperadorappalrep2() {
		return codoperadorappalrep2;
	}

	public void setCodoperadorappalrep2(String codoperadorappalrep2) {
		this.codoperadorappalrep2 = codoperadorappalrep2;
	}

	public String getTextoTlfPpalRpr2() {
		return textoTlfPpalRpr2;
	}

	public void setTextoTlfPpalRpr2(String textoTlfPpalRpr2) {
		this.textoTlfPpalRpr2 = textoTlfPpalRpr2;
	}

	public String getCodoperadorasecrep2() {
		return codoperadorasecrep2;
	}

	public void setCodoperadorasecrep2(String codoperadorasecrep2) {
		this.codoperadorasecrep2 = codoperadorasecrep2;
	}

	public String getTextoTlfSecRpr2() {
		return textoTlfSecRpr2;
	}

	public void setTextoTlfSecRpr2(String textoTlfSecRpr2) {
		this.textoTlfSecRpr2 = textoTlfSecRpr2;
	}

	public String getEmailRpr2() {
		return emailRpr2;
	}

	public void setEmailRpr2(String emailRpr2) {
		this.emailRpr2 = emailRpr2;
	}

	public Long getIdRpr1() {
		return idRpr1;
	}

	public void setIdRpr1(Long idRpr1) {
		this.idRpr1 = idRpr1;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Long getIdRpr2() {
		return idRpr2;
	}

	public void setIdRpr2(Long idRpr2) {
		this.idRpr2 = idRpr2;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getAnnio() {
		return annio;
	}

	public void setAnnio(String annio) {
		this.annio = annio;
	}

	public String getAnnioescolar() {
		return annioescolar;
	}

	public void setAnnioescolar(String annioescolar) {
		this.annioescolar = annioescolar;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
