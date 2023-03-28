package com.tecnodestreza.siga.repo;

import com.tecnodestreza.siga.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario,Long> {

	public Usuario findByUsername(String username);
	
	//public Usuario findByCedula(String cedula);
	
}
