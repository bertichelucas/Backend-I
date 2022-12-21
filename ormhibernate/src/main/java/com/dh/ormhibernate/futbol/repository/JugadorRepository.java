package com.dh.ormhibernate.futbol.repository;

import com.dh.ormhibernate.futbol.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}
