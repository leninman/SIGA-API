package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Seccion;
import com.tecnodestreza.siga.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepo extends JpaRepository<Turno, Long> {

}
