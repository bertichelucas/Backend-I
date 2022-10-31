import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class Empleado {

    private long id;
    private String nombre;
    private int edad;
    private String empresa;
    //private LocalDate fechaInicio;



    public String toStringSQL() {
        return id + ", " +
                "\'" +nombre + "\'"+ ", " +
                edad + ", " +
                "\'"+ empresa + "\'";

    }
}
