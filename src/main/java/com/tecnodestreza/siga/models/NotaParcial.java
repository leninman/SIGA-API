package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notas_parciales")
public class NotaParcial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "alumno", referencedColumnName = "id")
    private Alumno alumno;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "docente", referencedColumnName = "id")
    private Docente docente;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "curso", referencedColumnName = "id")
    private Curso curso;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "materia", referencedColumnName = "id")
    private Materia materia;
    private String lapso;
    private String nota;
    private String porcentaje;


}
