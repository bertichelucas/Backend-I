import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Long id;
    private String nombre, email;
    private double sueldo;

    public Usuario(String nombre, String email, double sueldo) {
        this.nombre = nombre;
        this.email = email;
        this.sueldo = sueldo;
    }

    public double subirSueldo(double precio){
        this.sueldo += precio;
        return this.sueldo;
    }
}
