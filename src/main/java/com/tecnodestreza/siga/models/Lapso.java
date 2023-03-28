/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnodestreza.siga.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author lenin
 */
@Entity
@Table(name = "lapsos")
public class Lapso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LAPSO")
    private Long idLapso;
    
    private String periodo;
    
    private String descripcion;
    
    private Float porcentaje;
    
    public Long getIdLapso() {
        return idLapso;
    }

    public void setIdLapso(Long idLapso) {
        this.idLapso = idLapso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Float porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    

    
    
    

}
