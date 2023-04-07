/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Lenin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "annio_escolar")
public class AnnioEscolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANNIO_ESC")
    private Long idAnnioEsc;
    @Basic(optional = false)
    @Column(name = "INT_ANNIO_ESC")
    private String intAnnioEsc;
    @Column(name = "FECHA_I")
    private Date fechaI;
    @Column(name = "FECHA_F")
    private Date fechaF;
    @Column(name = "STATUS")
    private String status;
}
