import lombok.Getter;

@Getter
public class EmpleadoContratado extends Empleado{

    private int cantidadHoras;
    private double valorPorHora;

    public EmpleadoContratado(String nombre, String apellido, String cuentaBancaria, int cantidadHoras, double valorPorHora) {
        super(nombre, apellido, cuentaBancaria);
        this.cantidadHoras = cantidadHoras;
        this.valorPorHora = valorPorHora;
    }
}
