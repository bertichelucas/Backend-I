import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Empleado {

    private String nombre, apellido;
    private Integer legajo;
    private Double sueldo;

    public String toStringConFormato(){
        return this.nombre + ";" +
               this.apellido + ";" +
               this.legajo + ";" +
                this.sueldo;
    }

}
