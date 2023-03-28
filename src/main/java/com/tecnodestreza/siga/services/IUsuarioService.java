package com.tecnodestreza.siga.services;

import com.tecnodestreza.siga.models.DTOS.PersonaDTO;
import com.tecnodestreza.siga.models.Usuario;

public interface IUsuarioService {
	
	public Usuario findUsuarioByCedulaAndTipoUsuario(String tipodoc, String numdoc, String tipousuario);
	
	public PersonaDTO findPersonaByCedulaAndTipoUsuario(String tipodoc, String numdoc, String tipoUsuario);
	
        public Usuario findUsuarioByUserName(String username);
}
