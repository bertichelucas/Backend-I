package com.h2.estudiantesHQL.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.estudiantesHQL.entity.Cursada;
import com.h2.estudiantesHQL.entity.CursadaDTO;
import com.h2.estudiantesHQL.entity.Estudiante;
import com.h2.estudiantesHQL.repository.CursadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CursadaService implements ICursadaService{

    private CursadaRepository cursadaRepository;
    private ObjectMapper mapper;

    @Autowired

    public CursadaService(CursadaRepository cursadaRepository, ObjectMapper mapper) {
        this.cursadaRepository = cursadaRepository;
        this.mapper = mapper;
    }


    @Override
    public CursadaDTO crearCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
        return  cursadaDTO;
    }

    @Override
    public CursadaDTO leerCursada(Long id) {
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        CursadaDTO cursadaDTO = null;
        if(cursada.isPresent()){
            cursadaDTO = mapper.convertValue(cursada, CursadaDTO.class);
        }
        return cursadaDTO;
    }

    @Override
    public void modificarCursada(CursadaDTO cursadaDTO) {
        Cursada cursada = mapper.convertValue(cursadaDTO, Cursada.class);
        cursadaRepository.save(cursada);
    }

    @Override
    public void eliminarCursada(Long id) {
        cursadaRepository.deleteById(id);
    }

    @Override
    public Set<CursadaDTO> getTodos() {
        List<Cursada> cursadas = cursadaRepository.findAll();
        Set<CursadaDTO> cursadaSet = new HashSet<>();
        for (Cursada cursada: cursadas) {
            cursadaSet.add(mapper.convertValue(cursada, CursadaDTO.class));
        }
        return cursadaSet;
    }
}
