import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VacunatorioTest {

    @Test
    public void casoCorrecto(){
        //GIVEN
        VacunatorioProxy vp = new VacunatorioProxy();
        Persona p = new Persona("Juan", "Perez", "1234123", "Pfizer", new Date(122,9,05));
        String rtaEsperada = "DNI: " + "1234123" + ", vacunado con: " + "Pfizer";

        //WHEN
        String rta = vp.vacunar(p);

        //THEN
        Assertions.assertEquals(rtaEsperada, rta);

    }
}
