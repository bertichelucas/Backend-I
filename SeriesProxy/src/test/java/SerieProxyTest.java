import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SerieProxyTest {

    @Test
    public void testSerieProxy(){
        //GIVEN
        SerieProxy sp = new SerieProxy();

        //WHEN
        String rta = sp.getPelicula("HarryPotter");

        //THEN
        Assertions.assertEquals(rta, "www.HarryPotter");
    }
}
