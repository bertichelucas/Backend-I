import org.junit.jupiter.api.Test;

public class ListaTest {

    @Test
    public void TestLista(){
        //GIVEN
        ListaReproduccion lr = new ListaReproduccion("Mi playlist");

        //WHEN
        for (int i = 0; i < 100; i++){
            lr.agregarCancion("prueba" + (i % 2));
        }

        //THEN
        System.out.println(lr);
    }
}
