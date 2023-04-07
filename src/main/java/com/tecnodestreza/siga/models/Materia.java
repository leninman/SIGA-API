package com.tecnodestreza.siga.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
/**
 * The persistent class for the materias database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="materias")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_MAT")
	private Long idMat;
	@Basic(optional = false)
	@Column(name="CODIGO_MAT")
	private String codigoMat;
	@Basic(optional = false)
	@Column(name="DESCRIPCION_MAT")
	private String descripcionMat;
	@ManyToOne
    @JoinColumn(name = "ID_ANNIO",nullable=false)
    private Annio annio;
	@Basic(optional = false)
	@Column(name="NOMBRE_MAT")
	private String nombreMat;
	@Basic(optional = false)
	@Column(name="STATUS")
	private String status;
}