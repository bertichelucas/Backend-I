import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LiquidadorTest {

    @Test
    @DisplayName("Liquidacion Empleado Efectivo")
    public void pruebaLiquidacionEfectivo(){
        //GIVEN
        Empleado empleado = new EmpleadoEfectivo("Juan", "Perez", "312312412", 75000.25, 5284.0, 5984.0);
        Liquidador liquidador = new LiquidadorEmpleadoEfectivo();
        String rtaEsperada = "La liquidacion generada es un documento escrito.Saldo a liquidar: 74300.25";

        //WHEN
        String resultado = liquidador.liquidarSueldo(empleado);
        //THEN
        Assertions.assertEquals(rtaEsperada, resultado);
    }
}
