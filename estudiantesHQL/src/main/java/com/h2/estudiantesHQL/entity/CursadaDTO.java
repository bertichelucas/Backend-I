package com.h2.estudiantesHQL.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursadaDTO {

    private Long id;

    private Double nota;

    private Estudiante estudiante;

    private Materia materia;

}
