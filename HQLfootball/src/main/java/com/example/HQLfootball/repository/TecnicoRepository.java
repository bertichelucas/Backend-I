package com.example.HQLfootball.repository;

import com.example.HQLfootball.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {


    @Query("SELECT t FROM Tecnico t WHERE t.nombre =?1")
    Optional<Tecnico> buscarTecnicoPorNombre(String nombre);
}
