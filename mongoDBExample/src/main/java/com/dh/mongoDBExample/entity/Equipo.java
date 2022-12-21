package com.dh.mongoDBExample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Equipo {

    private Integer id;
    private String nombre, pais;

}
