package com.tecnodestreza.siga.models.DTOS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String tipoDocumento;
	private String numeroDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
}
