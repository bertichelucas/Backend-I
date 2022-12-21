package com.dh.ormhibernate.movimiento.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesores")
@Getter
@Setter
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre, titulo;

    @OneToMany(mappedBy = "profesor",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Estudiante> estudiantes = new HashSet<>();
}
