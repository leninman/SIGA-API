package com.tecnodestreza.siga.security.service;

import com.tecnodestreza.siga.security.entity.Rol;
import com.tecnodestreza.siga.security.enums.RolNombre;
import com.tecnodestreza.siga.security.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class RolService {
    private final RolRepository rolRepository;
    public Optional<Rol> getRolByRolName(String rolNombre){
        return rolRepository.findRolByRolNombre(rolNombre);
    }

}
