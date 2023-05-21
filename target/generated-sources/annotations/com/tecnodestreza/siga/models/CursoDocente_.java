package com.tecnodestreza.siga.models;

import com.tecnodestreza.siga.models.Curso;
import com.tecnodestreza.siga.models.Docente;
import com.tecnodestreza.siga.models.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-20T21:55:20")
@StaticMetamodel(CursoDocente.class)
public class CursoDocente_ { 

    public static volatile SingularAttribute<CursoDocente, Curso> curso;
    public static volatile SingularAttribute<CursoDocente, Docente> docente;
    public static volatile SingularAttribute<CursoDocente, Materia> materia;
    public static volatile SingularAttribute<CursoDocente, Long> id;

}