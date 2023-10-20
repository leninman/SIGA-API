package com.tecnodestreza.siga.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
public class Docentedto {
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
    private String codigoOperadoraTelefono;
    private String telefono;
    private String email;
    private String lugarDeNacimiento;
    private String nacionalidad;
    private Date fechaIngreso;
    private Date fechaCreacion;
    private Boolean activo;
    private String condicion;
    private String estadoCivil;
    private String pregrado1;
    private String pregrado2;
    private String postgrado1;
    private String postgrado2;
    private String curso1;
    private String curso2;
    private String curso3;
    private String curso4;
    private String graduadoPregrado1;
    private String categoria;
    private Integer tiempoDeServicio;
    private String asignaturasEspecializadas;

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
        this.email = email;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil.toUpperCase();
    }

    public String getPregrado1() {
        return pregrado1;
    }

    public void setPregrado1(String pregrado1) {
        this.pregrado1 = pregrado1.toUpperCase();
    }

    public String getPregrado2() {
        return pregrado2;
    }

    public void setPregrado2(String pregrado2) {
        if(pregrado2!=null) {
            this.pregrado2 = pregrado2.toUpperCase();
        }
    }

    public String getPostgrado1() {
        return postgrado1;
    }

    public void setPostgrado1(String postgrado1) {
        if(postgrado1!=null) {
            this.postgrado1 = postgrado1.toUpperCase();
        }
    }

    public String getPostgrado2() {
        return postgrado2;
    }

    public void setPostgrado2(String postgrado2) {
        if(postgrado2!=null) {
            this.postgrado2 = postgrado2.toUpperCase();
        }
    }

    public String getCurso1() {
        return curso1;
    }

    public void setCurso1(String curso1) {
        if(curso1!=null) {
            this.curso1 = curso1.toUpperCase();
        }
    }

    public String getCurso2() {
        return curso2;
    }

    public void setCurso2(String curso2) {
        if(curso2!=null) {
            this.curso2 = curso2.toUpperCase();
        }
    }

    public String getCurso3() {
        return curso3;
    }

    public void setCurso3(String curso3) {
        if(curso3!=null) {
            this.curso3 = curso3.toUpperCase();
        }
    }

    public String getCurso4() {
        return curso4;
    }

    public void setCurso4(String curso4) {
        if(curso4!=null) {
            this.curso4 = curso4.toUpperCase();
        }
    }

    public String getGraduadoPregrado1() {
        return graduadoPregrado1;
    }

    public void setGraduadoPregrado1(String graduadoPregrado1) {
        if(graduadoPregrado1!=null) {
            this.graduadoPregrado1 = graduadoPregrado1.toUpperCase();
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if(categoria!=null) {
            this.categoria = categoria.toUpperCase();
        }
    }

    public Integer getTiempoDeServicio() {
        return tiempoDeServicio;
    }

    public void setTiempoDeServicio(Integer tiempoDeServicio) {
        this.tiempoDeServicio = tiempoDeServicio;
    }

    public String getAsignaturasEspecializadas() {
        return asignaturasEspecializadas;
    }

    public void setAsignaturasEspecializadas(String asignaturasEspecializadas) {
        if(asignaturasEspecializadas!=null) {
            this.asignaturasEspecializadas = asignaturasEspecializadas.toUpperCase();
        }
    }
}
