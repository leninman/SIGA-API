package com.tecnodestreza.siga.security.repository;

import com.tecnodestreza.siga.security.entity.Rol;
import com.tecnodestreza.siga.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findRolByRolNombre(String rolNombre);
}
