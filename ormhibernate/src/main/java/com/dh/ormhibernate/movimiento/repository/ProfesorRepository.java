package com.dh.ormhibernate.movimiento.repository;

import com.dh.ormhibernate.movimiento.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
