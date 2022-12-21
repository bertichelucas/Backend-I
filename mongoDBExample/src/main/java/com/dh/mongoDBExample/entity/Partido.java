package com.dh.mongoDBExample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document()
public class Partido {

    private Integer id;
    private Estado estado;
    private String resultado;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
}
