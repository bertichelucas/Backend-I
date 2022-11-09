import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {


        List<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new Empleado("Juan", "Lopez", 2134, 200.0));
        listaEmpleados.add(new Empleado("Carlos", "Gardel", 31241, 1500.4));
        listaEmpleados.add(new Empleado("Lucas", "Bertiche", 4213, 11201d));

        ManejadorEntradaSalida.guardarListaEmpleados(listaEmpleados);
    }
}
