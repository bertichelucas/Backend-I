import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado {

    private String nombre, apellido, cuentaBancaria;

    public Empleado(String nombre, String apellido, String cuentaBancaria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentaBancaria = cuentaBancaria;
    }
}
