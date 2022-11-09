package model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class Paciente {

    private Integer id;
    private String nombre, apellido, dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, String dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
