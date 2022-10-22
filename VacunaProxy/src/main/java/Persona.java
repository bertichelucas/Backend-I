import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor

public class Persona {

    private String nombre, apellido, dni, nombreVacuna;
    private Date fechaAsignada;


}
