package com.h2.estudiantesHQL.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.h2.estudiantesHQL.entity.Estudiante;
import com.h2.estudiantesHQL.entity.EstudianteDTO;
import com.h2.estudiantesHQL.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EstudianteService implements IEstudianteService{

    private EstudianteRepository estudianteRepository;
    ObjectMapper mapper;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, ObjectMapper mapper) {
        this.estudianteRepository = estudianteRepository;
        this.mapper = mapper;
    }

    @Override
    public EstudianteDTO crearEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
        return  estudianteDTO;
    }

    @Override
    public EstudianteDTO leerEstudiante(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        EstudianteDTO estudianteDTO = null;
        if (estudiante.isPresent()){
            estudianteDTO = mapper.convertValue(estudiante, EstudianteDTO.class);
        }
        return estudianteDTO;
    }

    @Override
    public void modificarEstudiante(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = mapper.convertValue(estudianteDTO, Estudiante.class);
        estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Set<EstudianteDTO> getTodos() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        Set<EstudianteDTO> setEstudiantes = new HashSet<>();

        for (Estudiante es: estudiantes) {
            setEstudiantes.add(mapper.convertValue(es, EstudianteDTO.class));
        }
        return setEstudiantes;
    }
}
