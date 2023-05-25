package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Condicion;
import com.tecnodestreza.siga.models.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICondicionRepo extends JpaRepository<Condicion, Long> {

}
