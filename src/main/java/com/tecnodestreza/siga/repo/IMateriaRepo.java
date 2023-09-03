package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepo extends JpaRepository<Materia, Long> {
}
