package com.dh.mongoDBExample.repository;

import com.dh.mongoDBExample.entity.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends MongoRepository<Partido, Integer> {

}
