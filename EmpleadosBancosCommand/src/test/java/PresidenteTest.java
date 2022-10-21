import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PresidenteTest {

    @Test
    @DisplayName("Test Presidente Lee documento")
    public void TestPresidenteLeer(){
        //GIVEN
        Documento doc = new Documento("Texto1", 2);
        PresidenteCommand pc = new PresidenteCommand();
        String resEsperado = "Leido por el presidente";
        //WHEN
        String rta = pc.leerDocumento(doc);
        //THEN
        Assertions.assertEquals(resEsperado, rta);
    }
}
