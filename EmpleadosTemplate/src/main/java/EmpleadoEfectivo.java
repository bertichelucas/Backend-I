import lombok.Getter;
import lombok.Setter;

@Getter
public class EmpleadoEfectivo extends Empleado{

    private double sueldoBasico, premios, descuentos;

    public EmpleadoEfectivo(String nombre, String apellido, String cuentaBancaria, double sueldoBasico, double premios, double descuentos) {
        super(nombre, apellido, cuentaBancaria);
        this.sueldoBasico = sueldoBasico;
        this.premios = premios;
        this.descuentos = descuentos;
    }
}
