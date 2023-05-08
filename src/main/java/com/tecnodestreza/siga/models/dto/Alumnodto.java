package com.tecnodestreza.siga.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alumnodto {

    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String sexo;
    private Date fechaNacimiento;
    private String edad;
    private String direccion;
    private String telefono;
    private String email;
    private Date fechaIngreso;
    private String representanteTipoDocumento;
    private String representanteNumeroDocumento;
    private String representantePrimerNombre;
    private String representantesegundoNombre;
    private String representantePrimerApellido;
    private String representanteSegundoApellido;
    private String representanteSexo;
    private Date representanteFechaNacimieno;
    private String representanteEdad;
    private String representanteEstadoCivil;
    private String representanteDireccion;
    private String representanteEmpresaDondeTrabaja;
    private String representanteDireccionLaboral;
    private String representanteTelefono;
    private String representanteTelefonoEmpresa;
    private String representanteEmail;
    private Boolean representanteActivo;
    private String representanteProfesion;
    private String representanteOcupacion;
    private String parentesco;
    private String cursoAnnio;
    private String cursoSeccion;
    private String cursoPeriodoAcademico;
    private String cursoTurno;
    private String cursoNivel;
    private Date fechaCreacion;
    private Boolean activo;
    private String condicion;
}
