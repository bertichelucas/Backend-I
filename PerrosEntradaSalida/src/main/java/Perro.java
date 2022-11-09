import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class Perro implements Serializable {

    private Integer edad;
    private String nombre;


    @Override
    public String toString() {
        return "Perro{" +
                "edad=" + edad +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
