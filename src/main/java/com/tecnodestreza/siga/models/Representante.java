/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
@Entity
@Table(name = "representantes")
public class Representante implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_RPR")
	private Long idRpr;
	@Basic(optional = false)
	@Column(name = "TIPO_DOC_RPR")
	private String tipoDocRpr;
	@Basic(optional = false)
	@Column(name = "NUM_DOC_RPR")
	private String numDocRpr;
	@Basic(optional = false)
	@Column(name = "PRIM_NOMB_RPR")
	private String primNombRpr;
	@Column(name = "SEG_NOMB_RPR")
	private String segNombRpr;
	@Basic(optional = false)
	@Column(name = "PRIM_APELL_RPR")
	private String primApellRpr;
	@Column(name = "SEG_APELL_RPR")
	private String segApellRpr;
	@Basic(optional = false)
	@Column(name = "SEXO_RPR")
	private String sexoRpr;
	@Basic(optional = false)
	@Column(name = "FECH_NAC_RPR")
	@Temporal(TemporalType.DATE)
	private Date fechNacRpr;
	@Basic(optional = false)
	@Column(name = "EDAD_RPR")
	private String edadRpr;
	@Basic(optional = false)
	@Column(name = "EDO_CIV_RPR")
	private String edoCivRpr;
	@Basic(optional = false)
	@Column(name = "DIR_PPAL_RPR")
	private String dirPpalRpr;
	@Basic(optional = false)
	@Column(name = "DIR_SEC_RPR")
	private String dirSecRpr;
	@Basic(optional = false)
	@Column(name = "TLF_PPAL_RPR")
	private String tlfPpalRpr;
	@Basic(optional = false)
	@Column(name = "TLF_SEC_RPR")
	private String tlfSecRpr;
	@Basic(optional = false)
	@Column(name = "EMAIL_RPR")
	private String emailRpr;
}
