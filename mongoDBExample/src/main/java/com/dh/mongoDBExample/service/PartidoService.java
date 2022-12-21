package com.dh.mongoDBExample.service;

import com.dh.mongoDBExample.entity.Partido;
import com.dh.mongoDBExample.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {

    private PartidoRepository partidoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository){
        this.partidoRepository = partidoRepository;
    }

    public Partido agregarPartido(Partido partido){
        return this.partidoRepository.save(partido);
    }

}
