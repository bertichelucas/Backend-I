package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Medicamento {

    private Integer Id;
    private String nombre, laboratorio;
    private Integer cantidad;
    private Double precio;
    private Integer codigo;


}
