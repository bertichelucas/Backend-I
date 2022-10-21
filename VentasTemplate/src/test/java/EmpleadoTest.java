import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    @Test
    @DisplayName("Test Empleado Puntos")
    public void TestEmpleadoCalcularPuntos(){
        //GIVEN
        Empleado emp = new Empleado("Charles", 5);
        //WHEN
        emp.conseguirAfiliado();
        emp.conseguirAfiliado();
        emp.vender();
        //THEN
        Assertions.assertEquals(emp.calcularPuntos(), 50);
    }

    @Test
    @DisplayName("Test Empleado Mostrar Categoria")
    public void TestEmpleadoMostrarCategoria(){
        //GIVEN
        Empleado emp = new Empleado("Charles", 5);
        String resultadoEsperado = "Vendedor{" +
                "nombre='" + "Charles" + '\'' +
                ", categoria='" + "maestro" + '\'' +
                ", puntos=" + 50 +
                '}';
        //WHEN
        emp.conseguirAfiliado();
        emp.conseguirAfiliado();
        emp.vender();
        //THEN
        Assertions.assertEquals(emp.mostrarCategoria(), resultadoEsperado);
    }
}
