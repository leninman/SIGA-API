package com.tecnodestreza.siga.security.repo;


import com.tecnodestreza.siga.security.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
