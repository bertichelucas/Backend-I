import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Contacto implements Serializable {

    private String nombre, mail, telefono;

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
