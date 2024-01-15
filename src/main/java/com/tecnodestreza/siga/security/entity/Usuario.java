package com.tecnodestreza.siga.security.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String email;
    private String password;
    @Column(name = "num_intentos_fallidos")
    private Integer numIntentosFallidos;
    private Boolean activo;
    @Column(name = "fecha_ultima_conexion")
    private Date fechaUltimaConexion;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="usuario_rol",joinColumns = @JoinColumn(name="usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roles;


}
