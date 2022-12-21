package com.h2.estudiantesHQL.service;

import com.h2.estudiantesHQL.entity.EstudianteDTO;

import java.util.Set;

public interface IEstudianteService {

    EstudianteDTO crearEstudiante (EstudianteDTO estudianteDTO);

    EstudianteDTO leerEstudiante(Long id);

    void modificarEstudiante(EstudianteDTO estudianteDTO);

    void eliminarEstudiante(Long id);

    Set<EstudianteDTO> getTodos();
}
