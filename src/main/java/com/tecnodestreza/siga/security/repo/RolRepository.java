package com.tecnodestreza.siga.security.repo;


import com.tecnodestreza.siga.security.entity.Rol;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends CrudRepository<Rol,Long> {
    Rol findByNombreRol(String nombreRol);


}
