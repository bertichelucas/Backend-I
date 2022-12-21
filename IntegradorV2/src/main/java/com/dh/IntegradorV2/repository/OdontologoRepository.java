package com.dh.IntegradorV2.repository;

import com.dh.IntegradorV2.model.Odontologo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}
