package com.example.HQLfootball.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tecnicos")
@Getter
@Setter
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private Integer edad;

    @OneToMany(mappedBy = "tecnico")
    private Set<Jugador> jugadores = new HashSet<>();

}
