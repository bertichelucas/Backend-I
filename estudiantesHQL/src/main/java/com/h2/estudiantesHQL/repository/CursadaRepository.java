package com.h2.estudiantesHQL.repository;

import com.h2.estudiantesHQL.entity.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Long> {
}
