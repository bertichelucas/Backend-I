package com.dh.ormhibernate.movimiento.repository;

import com.dh.ormhibernate.movimiento.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
