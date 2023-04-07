package com.tecnodestreza.siga.models.DTOS;
import com.tecnodestreza.siga.models.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long idPrf;
	private String primNombPrf;
	private String primApellPrf;
	private String aniosServPrf;
	private String catPrf;
	private String textoDirPpalPrf;
	private String estadodirppalprf;
	private String municipiodirppalprf;
	private String ciudaddirppalprf;
	private String parroquiadirppalprf;
	private String codpostaldirppalprf;
	private String textoDirSecPrf;
	private String estadodirsecprf;
	private String municipiodirsecprf;
	private String ciudaddirsecprf;
	private String parroquiadirsecprf;
	private String codpostaldirsecprf;
	private String edadPrf;
	private String edoCivilPrf;
	private String emailPrf;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechNacPrf;
	private String graduado;
	private String pregrado1;
	private String especialidad1;
	private String pregrado2;
	private String especialidad2;
	private String postgrado1;
	private String postgrado2;
	private String curso1;
	private String curso2;
	private String curso3;
	private String curso4;
	private String numDocPrf;
	private String segApellPrf;
	private String segNombPrf;
	private String sexoPrf;
	private String status;
	private String tipoDocPrf;
	private String codoperadorappalprf;
	private String textoTlfPpalPrf;
	private String codoperadorasecprf;
	private String textoTlfSecPrf;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechIngPrf;
	public ProfesorDTO(Profesor profesor) {
		String strDirPpalPrf = profesor.getDirPpalPrf();
		String[] arrOfStrDirPpalPrf = strDirPpalPrf.split(",");
		String strDirSecPrf = profesor.getDirSecPrf();
		String[] arrOfStrDirSecPrf = strDirSecPrf.split(",");
		String strTlfPpalPrf = profesor.getTlfPpalPrf();
		String[] arrOfStrTlfPpalPrf = strTlfPpalPrf.split("-");
		String strTlfSecPrf = profesor.getTlfSecPrf();
		String[] arrOfStrTlfSecPrf = strTlfSecPrf.split("-");
		String strPregrado1 = profesor.getPregrado1();
		String[] arrOfStrPregrado1 = strPregrado1.split("con especialidad en ");
		String strPregrado2;
		String[] arrOfStrPregrado2 = null;
		if (!profesor.getPregrado2().equals("")) {
			strPregrado2 = profesor.getPregrado2();
			arrOfStrPregrado2 = strPregrado2.split("con especialidad en ");
		} else {
			strPregrado2 = "";
		}
		this.idPrf = profesor.getIdPrf();
		this.aniosServPrf = profesor.getAniosServPrf();
		this.catPrf = profesor.getCatPrf();
		this.textoDirPpalPrf = arrOfStrDirPpalPrf[0];
		this.estadodirppalprf = arrOfStrDirPpalPrf[1];
		this.municipiodirppalprf = arrOfStrDirPpalPrf[2];
		this.ciudaddirppalprf = arrOfStrDirPpalPrf[3];
		this.parroquiadirppalprf = arrOfStrDirPpalPrf[4];
		this.codpostaldirppalprf = arrOfStrDirPpalPrf[5];
		this.textoDirSecPrf = arrOfStrDirSecPrf[0];
		this.estadodirsecprf = arrOfStrDirPpalPrf[1];
		this.municipiodirsecprf = arrOfStrDirPpalPrf[2];
		this.ciudaddirsecprf = arrOfStrDirPpalPrf[3];
		this.parroquiadirsecprf = arrOfStrDirPpalPrf[4];
		this.codpostaldirsecprf = arrOfStrDirPpalPrf[5];
		this.edadPrf = profesor.getEdadPrf();
		this.edoCivilPrf = profesor.getEdoCivilPrf();
		this.emailPrf = profesor.getEmailPrf();
		this.fechNacPrf = profesor.getFechNacPrf();
		this.graduado = profesor.getGraduado();
		this.pregrado1 = arrOfStrPregrado1[0];
		this.especialidad1 = arrOfStrPregrado1[1];
		if (!strPregrado2.equals("") ) {
			this.pregrado2 = arrOfStrPregrado2[0];
			if(arrOfStrPregrado2.length==2) {
				this.especialidad2 = arrOfStrPregrado2[1];
			}else {
				this.especialidad2="";
			}
			
		}else {
			this.pregrado2 = "";
			this.especialidad2 = "";
		}
		//this.pregrado2 = profesor.getPregrado2();
		this.postgrado1 = profesor.getPostgrado1();
		this.postgrado2 = profesor.getPostgrado2();
		this.curso1 = profesor.getCurso1();
		this.curso2 = profesor.getCurso2();
		this.curso3 = profesor.getCurso3();
		this.curso4 = profesor.getCurso4();
		this.numDocPrf = profesor.getNumDocPrf();
		this.primApellPrf = profesor.getPrimApellPrf();
		this.primNombPrf = profesor.getPrimNombPrf();
		this.segApellPrf = profesor.getSegApellPrf();
		this.segNombPrf = profesor.getSegNombPrf();
		this.sexoPrf = profesor.getSexoPrf();
		this.status = profesor.getStatus();
		this.tipoDocPrf = profesor.getTipoDocPrf();
		this.codoperadorappalprf = arrOfStrTlfPpalPrf[0];
		this.textoTlfPpalPrf = arrOfStrTlfPpalPrf[1];
		this.codoperadorasecprf = arrOfStrTlfSecPrf[0];
		this.textoTlfSecPrf = arrOfStrTlfSecPrf[1];
		this.fechIngPrf = profesor.getFechIngPrf();
	}
}
