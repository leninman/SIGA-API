package com.tecnodestreza.siga.models.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Alumnodto {

    @NotEmpty
    private String tipoDocumento;
    @NotEmpty
    private String numeroDocumento;
    @NotEmpty
    private String primerNombre;
    @NotEmpty
    private String segundoNombre;
    @NotEmpty
    private String primerApellido;
    @NotEmpty
    private String segundoApellido;
    @NotEmpty
    private String sexo;
    @NotNull
    private Date fechaNacimiento;
    @NotEmpty
    private String edad;
    @NotEmpty
    private String direccion;
    @NotEmpty
    private String codigoOperadoraTelefono;
    @NotEmpty
    private String telefono;
    @NotEmpty
    private String email;
    @NotNull
    private Date fechaIngreso;
    @NotEmpty
    private String lugarDeNacimiento;
    @NotEmpty
    private String nacionalidad;
    @NotEmpty
    private String representanteTipoDocumento;
    @NotEmpty
    private String representanteNumeroDocumento;
    @NotEmpty
    private String representantePrimerNombre;
    @NotEmpty
    private String representanteSegundoNombre;
    @NotEmpty
    private String representantePrimerApellido;
    @NotEmpty
    private String representanteSegundoApellido;
    @NotEmpty
    private String representanteSexo;
    @NotNull
    private Date representanteFechaNacimieno;
    @NotEmpty
    private String representanteEdad;
    @NotEmpty
    private String representanteEstadoCivil;
    @NotEmpty
    private String representanteDireccion;
    @NotEmpty
    private String representanteLugarDeNacimiento;
    @NotEmpty
    private String representanteNacionalidad;
    @NotEmpty
    private String representanteIngresoMensualAproximado;
    @NotEmpty
    private String representanteEmpresaDondeTrabaja;
    @NotEmpty
    private String representanteDireccionLaboral;
    @NotEmpty
    private String representanteCodigoOperadoraTelefono;
    @NotEmpty
    private String representanteTelefono;
    @NotEmpty
    private String representanteCodigoOperadoraTelefonoEmpresa;
    @NotEmpty
    private String representanteTelefonoEmpresa;
    @NotEmpty
    private String representanteEmail;
    @NotNull
    private Boolean representanteActivo;
    @NotEmpty
    private String representanteProfesion;
    @NotEmpty
    private String representanteOcupacion;
    @NotEmpty
    private String parentesco;
    @NotEmpty
    private String cursoAnnio;
    @NotEmpty
    private String cursoSeccion;
    @NotEmpty
    private String cursoPeriodoAcademico;
    @NotEmpty
    private String cursoTurno;
    @NotEmpty
    private String cursoNivel;

    private Date fechaCreacion;

    private Boolean activo;
    @NotEmpty
    private String condicion;

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento.toUpperCase();
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre.toUpperCase();
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre.toUpperCase();
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido.toUpperCase();
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido.toUpperCase();
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.toUpperCase();
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.toUpperCase();
    }

    public String getCodigoOperadoraTelefono() {
        return codigoOperadoraTelefono;
    }

    public void setCodigoOperadoraTelefono(String codigoOperadoraTelefono) {
        this.codigoOperadoraTelefono = codigoOperadoraTelefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toUpperCase();
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLugarDeNacimiento() {
        return lugarDeNacimiento;
    }

    public void setLugarDeNacimiento(String lugarDeNacimiento) {
        this.lugarDeNacimiento = lugarDeNacimiento.toUpperCase();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad.toUpperCase();
    }

    public String getRepresentanteTipoDocumento() {
        return representanteTipoDocumento;
    }

    public void setRepresentanteTipoDocumento(String representanteTipoDocumento) {
        this.representanteTipoDocumento = representanteTipoDocumento.toUpperCase();
    }

    public String getRepresentanteNumeroDocumento() {
        return representanteNumeroDocumento;
    }

    public void setRepresentanteNumeroDocumento(String representanteNumeroDocumento) {
        this.representanteNumeroDocumento = representanteNumeroDocumento;
    }

    public String getRepresentantePrimerNombre() {
        return representantePrimerNombre;
    }

    public void setRepresentantePrimerNombre(String representantePrimerNombre) {
        this.representantePrimerNombre = representantePrimerNombre.toUpperCase();
    }

    public String getRepresentanteSegundoNombre() {
        return representanteSegundoNombre;
    }

    public void setRepresentanteSegundoNombre(String representanteSegundoNombre) {
        this.representanteSegundoNombre = representanteSegundoNombre.toUpperCase();
    }

    public String getRepresentantePrimerApellido() {
        return representantePrimerApellido;
    }

    public void setRepresentantePrimerApellido(String representantePrimerApellido) {
        this.representantePrimerApellido = representantePrimerApellido.toUpperCase();
    }

    public String getRepresentanteSegundoApellido() {
        return representanteSegundoApellido;
    }

    public void setRepresentanteSegundoApellido(String representanteSegundoApellido) {
        this.representanteSegundoApellido = representanteSegundoApellido.toUpperCase();
    }

    public String getRepresentanteSexo() {
        return representanteSexo;
    }

    public void setRepresentanteSexo(String representanteSexo) {
        this.representanteSexo = representanteSexo.toUpperCase();
    }

    public Date getRepresentanteFechaNacimieno() {
        return representanteFechaNacimieno;
    }

    public void setRepresentanteFechaNacimieno(Date representanteFechaNacimieno) {
        this.representanteFechaNacimieno = representanteFechaNacimieno;
    }

    public String getRepresentanteEdad() {
        return representanteEdad;
    }

    public void setRepresentanteEdad(String representanteEdad) {
        this.representanteEdad = representanteEdad;
    }

    public String getRepresentanteEstadoCivil() {
        return representanteEstadoCivil;
    }

    public void setRepresentanteEstadoCivil(String representanteEstadoCivil) {
        this.representanteEstadoCivil = representanteEstadoCivil.toUpperCase();
    }

    public String getRepresentanteDireccion() {
        return representanteDireccion;
    }

    public void setRepresentanteDireccion(String representanteDireccion) {
        this.representanteDireccion = representanteDireccion.toUpperCase();
    }

    public String getRepresentanteLugarDeNacimiento() {
        return representanteLugarDeNacimiento;
    }

    public void setRepresentanteLugarDeNacimiento(String representanteLugarDeNacimiento) {
        this.representanteLugarDeNacimiento = representanteLugarDeNacimiento.toUpperCase();
    }

    public String getRepresentanteNacionalidad() {
        return representanteNacionalidad;
    }

    public void setRepresentanteNacionalidad(String representanteNacionalidad) {
        this.representanteNacionalidad = representanteNacionalidad.toUpperCase();
    }

    public String getRepresentanteIngresoMensualAproximado() {
        return representanteIngresoMensualAproximado;
    }

    public void setRepresentanteIngresoMensualAproximado(String representanteIngresoMensualAproximado) {
        this.representanteIngresoMensualAproximado = representanteIngresoMensualAproximado;
    }

    public String getRepresentanteEmpresaDondeTrabaja() {
        return representanteEmpresaDondeTrabaja;
    }

    public void setRepresentanteEmpresaDondeTrabaja(String representanteEmpresaDondeTrabaja) {
        this.representanteEmpresaDondeTrabaja = representanteEmpresaDondeTrabaja.toUpperCase();
    }

    public String getRepresentanteDireccionLaboral() {
        return representanteDireccionLaboral;
    }

    public void setRepresentanteDireccionLaboral(String representanteDireccionLaboral) {
        this.representanteDireccionLaboral = representanteDireccionLaboral.toUpperCase();
    }

    public String getRepresentanteCodigoOperadoraTelefono() {
        return representanteCodigoOperadoraTelefono;
    }

    public void setRepresentanteCodigoOperadoraTelefono(String representanteCodigoOperadoraTelefono) {
        this.representanteCodigoOperadoraTelefono = representanteCodigoOperadoraTelefono;
    }

    public String getRepresentanteTelefono() {
        return representanteTelefono;
    }

    public void setRepresentanteTelefono(String representanteTelefono) {
        this.representanteTelefono = representanteTelefono;
    }

    public String getRepresentanteCodigoOperadoraTelefonoEmpresa() {
        return representanteCodigoOperadoraTelefonoEmpresa;
    }

    public void setRepresentanteCodigoOperadoraTelefonoEmpresa(String representanteCodigoOperadoraTelefonoEmpresa) {
        this.representanteCodigoOperadoraTelefonoEmpresa = representanteCodigoOperadoraTelefonoEmpresa;
    }

    public String getRepresentanteTelefonoEmpresa() {
        return representanteTelefonoEmpresa;
    }

    public void setRepresentanteTelefonoEmpresa(String representanteTelefonoEmpresa) {
        this.representanteTelefonoEmpresa = representanteTelefonoEmpresa;
    }

    public String getRepresentanteEmail() {
        return representanteEmail;
    }

    public void setRepresentanteEmail(String representanteEmail) {
        this.representanteEmail = representanteEmail.toUpperCase();
    }

    public Boolean getRepresentanteActivo() {
        return representanteActivo;
    }

    public void setRepresentanteActivo(Boolean representanteActivo) {
        this.representanteActivo = representanteActivo;
    }

    public String getRepresentanteProfesion() {
        return representanteProfesion;
    }

    public void setRepresentanteProfesion(String representanteProfesion) {
        this.representanteProfesion = representanteProfesion.toUpperCase();
    }

    public String getRepresentanteOcupacion() {
        return representanteOcupacion;
    }

    public void setRepresentanteOcupacion(String representanteOcupacion) {
        this.representanteOcupacion = representanteOcupacion.toUpperCase();
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco.toUpperCase();
    }

    public String getCursoAnnio() {
        return cursoAnnio;
    }

    public void setCursoAnnio(String cursoAnnio) {
        this.cursoAnnio = cursoAnnio;
    }

    public String getCursoSeccion() {
        return cursoSeccion;
    }

    public void setCursoSeccion(String cursoSeccion) {
        this.cursoSeccion = cursoSeccion.toUpperCase();
    }

    public String getCursoPeriodoAcademico() {
        return cursoPeriodoAcademico;
    }

    public void setCursoPeriodoAcademico(String cursoPeriodoAcademico) {
        this.cursoPeriodoAcademico = cursoPeriodoAcademico.toUpperCase();
    }

    public String getCursoTurno() {
        return cursoTurno;
    }

    public void setCursoTurno(String cursoTurno) {
        this.cursoTurno = cursoTurno.toUpperCase();
    }

    public String getCursoNivel() {
        return cursoNivel;
    }

    public void setCursoNivel(String cursoNivel) {
        this.cursoNivel = cursoNivel.toUpperCase();
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion.toUpperCase();
    }
}
