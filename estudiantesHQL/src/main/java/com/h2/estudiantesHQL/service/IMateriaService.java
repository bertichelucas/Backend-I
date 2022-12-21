package com.h2.estudiantesHQL.service;

import com.h2.estudiantesHQL.entity.MateriaDTO;

import java.util.Set;

public interface IMateriaService {

    MateriaDTO crearMateria (MateriaDTO materiaDTO);

    MateriaDTO leerMateria(Long id);

    void modificarMateria(MateriaDTO materiaDTO);

    void eliminarMateria(Long id);

    Set<MateriaDTO> getTodos();
}
