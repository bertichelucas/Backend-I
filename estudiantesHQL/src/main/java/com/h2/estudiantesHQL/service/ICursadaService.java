package com.h2.estudiantesHQL.service;

import com.h2.estudiantesHQL.entity.CursadaDTO;

import java.util.Set;

public interface ICursadaService {

    CursadaDTO crearCursada (CursadaDTO cursadaDTO);

    CursadaDTO leerCursada(Long id);

    void modificarCursada(CursadaDTO cursadaDTO);

    void eliminarCursada(Long id);

    Set<CursadaDTO> getTodos();
}
