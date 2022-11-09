package model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Domicilio {

    private Integer id;
    private String calle;
    private Integer numero;
    private String localidad, provincia;

    public Domicilio(String calle, Integer numero, String localidad, String provincia){
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
