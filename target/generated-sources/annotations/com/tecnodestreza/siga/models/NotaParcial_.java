package com.tecnodestreza.siga.models;

import com.tecnodestreza.siga.models.Alumno;
import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-10-17T11:44:51")
@StaticMetamodel(NotaParcial.class)
public class NotaParcial_ { 

    public static volatile SingularAttribute<NotaParcial, Curso> curso;
    public static volatile SingularAttribute<NotaParcial, String> lapso;
    public static volatile SingularAttribute<NotaParcial, Docente> docente;
    public static volatile SingularAttribute<NotaParcial, Alumno> alumno;
    public static volatile SingularAttribute<NotaParcial, Materia> materia;
    public static volatile SingularAttribute<NotaParcial, Long> id;
    public static volatile SingularAttribute<NotaParcial, String> porcentaje;
    public static volatile SingularAttribute<NotaParcial, String> nota;

}