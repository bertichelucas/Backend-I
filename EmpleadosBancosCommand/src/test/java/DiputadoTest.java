import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiputadoTest {

    @Test
    @DisplayName("Test Diputado pasa documento a ministro")
    public void TestDiputadoLeer(){
        //GIVEN
        Documento doc = new Documento("Texto1", 2);
        DiputadoCommand dc = new DiputadoCommand();
        MinistroCommand mc = new MinistroCommand();
        dc.setSiguienteCommand(mc);
        String resEsperado = "Leido por el ministro";
        //WHEN
        String rta = dc.leerDocumento(doc);
        //THEN
        Assertions.assertEquals(resEsperado, rta);
    }
}
