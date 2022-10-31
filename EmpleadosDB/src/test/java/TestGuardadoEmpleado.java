import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
public class TestGuardadoEmpleado {

    @Test
    public void guardarEmpleado(){
        //GIVEN
        Empleado emp = new Empleado(1, "Charles", 25, "Digital");

        //WHEN
        try {
            ResultSet rs = GuardadoEmpleado.guardarEmpleado(emp);
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        //THEN


    }

}
