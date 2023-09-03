package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.EstadoCivil;
import com.tecnodestreza.siga.models.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoCivilRepo extends JpaRepository<EstadoCivil, Long> {

}
