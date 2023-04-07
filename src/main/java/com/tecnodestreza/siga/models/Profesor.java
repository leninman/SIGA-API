package com.tecnodestreza.siga.models;
import com.tecnodestreza.siga.models.DTOS.ProfesorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the profesores database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_PRF")
	private Long idPrf;
	@Column(name = "ANIOS_SERV_PRF")
	private String aniosServPrf;
	@Column(name = "CAT_PRF")
	private String catPrf;
	@Column(name = "DIR_PPAL_PRF")
	private String dirPpalPrf;
	@Column(name = "DIR_SEC_PRF")
	private String dirSecPrf;
	@Column(name = "EDAD_PRF")
	private String edadPrf;
	@Column(name = "EDO_CIVIL_PRF")
	private String edoCivilPrf;
	@Column(name = "EMAIL_PRF")
	private String emailPrf;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECH_NAC_PRF")
	private Date fechNacPrf;
	private String graduado;
	private String pregrado1;
	private String pregrado2;
	private String postgrado1;
	private String postgrado2;
	private String curso1;
	private String curso2;
	private String curso3;
	private String curso4;
	@Column(name = "NUM_DOC_PRF")
	private String numDocPrf;
	@Column(name = "PRIM_APELL_PRF")
	private String primApellPrf;
	@Column(name = "PRIM_NOMB_PRF")
	private String primNombPrf;
	@Column(name = "SEG_APELL_PRF")
	private String segApellPrf;
	@Column(name = "SEG_NOMB_PRF")
	private String segNombPrf;
	@Column(name = "SEXO_PRF")
	private String sexoPrf;
	private String status;
	@Column(name = "TIPO_DOC_PRF")
	private String tipoDocPrf;
	@Column(name = "TLF_PPAL_PRF")
	private String tlfPpalPrf;
	@Column(name = "TLF_SEC_PRF")
	private String tlfSecPrf;
	@Temporal(TemporalType.DATE)
	@Column(name = "FECH_ING_PRF")
	private Date fechIngPrf;
	public Profesor(ProfesorDTO profesordto) {

		this.idPrf = profesordto.getIdPrf();
		this.aniosServPrf = profesordto.getAniosServPrf();
		this.catPrf = profesordto.getCatPrf();
		this.dirPpalPrf = profesordto.getTextoDirPpalPrf().concat(",").concat(profesordto.getEstadodirppalprf())
				.concat(",").concat(profesordto.getMunicipiodirppalprf()).concat(",")
				.concat(profesordto.getCiudaddirppalprf()).concat(",").concat(profesordto.getParroquiadirppalprf())
				.concat(",").concat(profesordto.getCodpostaldirppalprf());

		if (profesordto.getTextoDirSecPrf() != "") {
			this.dirSecPrf = profesordto.getTextoDirSecPrf().concat(",").concat(profesordto.getEstadodirsecprf())
					.concat(",").concat(profesordto.getMunicipiodirsecprf()).concat(",")
					.concat(profesordto.getCiudaddirsecprf()).concat(",").concat(profesordto.getParroquiadirsecprf())
					.concat(",").concat(profesordto.getCodpostaldirsecprf());
		} else {
			this.dirSecPrf = this.dirPpalPrf;
		}

		this.edadPrf = profesordto.getEdadPrf();
		this.edoCivilPrf = profesordto.getEdoCivilPrf();
		this.emailPrf = profesordto.getEmailPrf();
		this.fechNacPrf = profesordto.getFechNacPrf();
		this.graduado = profesordto.getGraduado();
		this.pregrado1 = profesordto.getPregrado1().concat("con especialidad en ")
				.concat(profesordto.getEspecialidad1());
		if (profesordto.getPregrado2() != null && profesordto.getPregrado2() != "") {
			this.pregrado2 = profesordto.getPregrado2().concat("con especialidad en ")
					.concat(profesordto.getEspecialidad2());
		} else {
			this.pregrado2 = "";
		}
		if (profesordto.getPostgrado1() != null && profesordto.getPostgrado1() != "") {
			this.postgrado1 = profesordto.getPostgrado1();
		}
		if (profesordto.getPostgrado2() != null && profesordto.getPostgrado2() != "") {
			this.postgrado2 = profesordto.getPostgrado2();
		}
		if (profesordto.getCurso1() != null && profesordto.getCurso1() != "") {
			this.curso1 = profesordto.getCurso1();
		}
		if (profesordto.getCurso2() != null && profesordto.getCurso2() != "") {
			this.curso2 = profesordto.getCurso2();
		}
		if (profesordto.getCurso3() != null && profesordto.getCurso3() != "") {
			this.curso3 = profesordto.getCurso3();
		}

		if (profesordto.getCurso4() != null && profesordto.getCurso4() != "") {
			this.curso4 = profesordto.getCurso4();
		}
		this.numDocPrf = profesordto.getNumDocPrf();
		this.primApellPrf = profesordto.getPrimApellPrf();
		this.primNombPrf = profesordto.getPrimNombPrf();
		this.segApellPrf = profesordto.getSegApellPrf();
		this.segNombPrf = profesordto.getSegNombPrf();
		this.sexoPrf = profesordto.getSexoPrf();
		this.status = profesordto.getStatus();
		this.tipoDocPrf = profesordto.getTipoDocPrf();
		this.tlfPpalPrf = profesordto.getCodoperadorappalprf().concat("-").concat(profesordto.getTextoTlfPpalPrf());

		if (profesordto.getTextoTlfSecPrf() != "") {
			this.tlfSecPrf = profesordto.getCodoperadorasecprf().concat("-").concat(profesordto.getTextoTlfSecPrf());
		} else {
			this.tlfSecPrf = this.tlfPpalPrf;
		}

		this.fechIngPrf = profesordto.getFechIngPrf();
	}
}
