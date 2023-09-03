package com.tecnodestreza.siga.repo;


import com.tecnodestreza.siga.models.Lapso;
import com.tecnodestreza.siga.models.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILapsoRepo extends JpaRepository<Lapso, Long> {

    Optional<Lapso> findLapsoByValor(String valor);

}
