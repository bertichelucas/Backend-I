package com.example.HQLfootball.service;

import com.example.HQLfootball.entity.Tecnico;
import com.example.HQLfootball.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {

    private TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Optional<Tecnico> buscarTecnicoPorNombre(String nombre){
        return this.tecnicoRepository.buscarTecnicoPorNombre(nombre);
    }

    public Tecnico guardarTecnico(Tecnico tecnico){
        return this.tecnicoRepository.save(tecnico);
    }
}
