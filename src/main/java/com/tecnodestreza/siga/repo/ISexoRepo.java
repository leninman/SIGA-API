package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Sexo;
import com.tecnodestreza.siga.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISexoRepo extends JpaRepository<Sexo, Long> {

}
