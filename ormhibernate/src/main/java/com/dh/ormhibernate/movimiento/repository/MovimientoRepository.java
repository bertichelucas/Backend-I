package com.dh.ormhibernate.movimiento.repository;

import com.dh.ormhibernate.movimiento.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}
