import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaMailTest {

    @Test
    public void TestCompruebaMail(){
        //GIVEN
        CompruebaMail cm = new CompruebaMail();
        Mail mail = new Mail("adolfo@gmail.com","tecnica@colmena.com","tecnico");
        String rtaEsperada = "El correo se envio a tecnica";
        //WHEN
        String res = cm.checkCorreo(mail);

        //THEN
        Assertions.assertEquals(res,rtaEsperada);

    }
}