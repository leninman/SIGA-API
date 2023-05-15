package com.tecnodestreza.siga.models;

import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.Representante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-14T19:47:14")
@StaticMetamodel(Alumno.class)
public class Alumno_ { 

    public static volatile SingularAttribute<Alumno, String> segundoNombre;
    public static volatile SingularAttribute<Alumno, String> primerNombre;
    public static volatile SingularAttribute<Alumno, String> primerApellido;
    public static volatile SingularAttribute<Alumno, Date> fechaNacimiento;
    public static volatile SingularAttribute<Alumno, String> direccion;
    public static volatile SingularAttribute<Alumno, String> segundoApellido;
    public static volatile SingularAttribute<Alumno, String> edad;
    public static volatile SingularAttribute<Alumno, String> condicion;
    public static volatile SingularAttribute<Alumno, String> tipoDocumento;
    public static volatile SingularAttribute<Alumno, Date> fechaIngreso;
    public static volatile SingularAttribute<Alumno, Representante> representante;
    public static volatile SingularAttribute<Alumno, String> parentesco;
    public static volatile SingularAttribute<Alumno, Curso> curso;
    public static volatile SingularAttribute<Alumno, Date> fechaCreacion;
    public static volatile SingularAttribute<Alumno, Long> id;
    public static volatile SingularAttribute<Alumno, String> numeroDocumento;
    public static volatile SingularAttribute<Alumno, String> sexo;
    public static volatile SingularAttribute<Alumno, String> telefono;
    public static volatile SingularAttribute<Alumno, String> email;
    public static volatile SingularAttribute<Alumno, Boolean> activo;

}