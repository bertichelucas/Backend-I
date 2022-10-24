import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescargaProxyTest {

    @Test
    public void TestDescargaProxyPositivo(){
        //GIVEN
        DescargaProxy dp = new DescargaProxy();
        Usuario user = new Usuario(124, "Premium");

        //THEN
        Assertions.assertTrue(dp.descargar(user));


    }
}
