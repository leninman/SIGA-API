/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnodestreza.siga.models.DTOS;
import com.tecnodestreza.siga.models.Alumno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 * @author lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotaWrapperPorLapso implements Serializable {
    private Alumno alumno;
    private Float notalapso1;
    private Float porcentajenotalapso1;
    private Float notalapso2;
    private Float porcentajenotalapso2;
    private Float notalapso3;
    private Float porcentajenotalapso3;
}
