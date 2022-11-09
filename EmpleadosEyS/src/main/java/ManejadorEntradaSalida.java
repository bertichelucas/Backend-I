import java.util.List;
import java.io.*;

public class ManejadorEntradaSalida {

    public static void guardarListaEmpleados(List<Empleado> empleados){

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("empleados.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (Empleado empleado: empleados) {
                bos.write((empleado.toStringConFormato() + "\n").getBytes());
            }
            bos.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
