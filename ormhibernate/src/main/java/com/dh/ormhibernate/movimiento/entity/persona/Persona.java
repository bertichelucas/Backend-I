package com.dh.ormhibernate.movimiento.entity.persona;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Personas")
@IdClass(value= PersonaKey.class)
@Getter
@Setter

public class Persona {
    @Id
    private Integer dni;
    @Id
    private Integer numTramite;

}
