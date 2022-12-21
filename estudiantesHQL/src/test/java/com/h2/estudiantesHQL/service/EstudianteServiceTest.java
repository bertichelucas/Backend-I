package com.h2.estudiantesHQL.service;

import com.h2.estudiantesHQL.entity.EstudianteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EstudianteServiceTest {

    @Autowired
    private IEstudianteService estudianteService;

    @Test
    public void testCrearEstudiante(){

        //given
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        estudianteDTO.setNombre("Lucas");
        estudianteDTO.setApellido("Bertiche");

        //when
        EstudianteDTO resultado = estudianteService.crearEstudiante(estudianteDTO);

        //then
        assertTrue(resultado != null);
    }

}