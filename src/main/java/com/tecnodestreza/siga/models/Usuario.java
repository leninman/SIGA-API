package com.tecnodestreza.siga.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Usuario implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30, unique = true)
	private String username;
	@Column(length = 60)
	private String password;
	private Boolean enabled;
	@Column(length = 100)
	private String nombre;
	@Column(length = 50)
	private String correo;
	@Column(length = 100)
	private String clave1;
	@Column(length = 100)
	private String clave2;
	@Column(length = 100)
	private String clave3;
	@Column(length = 100)
	private String clave4;
	@Column(length = 100)
	private String clave5;
	@Column(length = 8)
	private String nrodoc;
	@Column(length = 1)
	private String tipodoc;
	@Column(length = 20)
	private String tipousuario;
	@Column(name="fecha_hora_ult_ingreso")
	private Date fechaHoraUltIngreso;
	@Column(name="fecha_hora_act_clave")
	private Date fechaHoraActClave;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;
}
