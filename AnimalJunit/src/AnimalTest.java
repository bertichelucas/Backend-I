import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    @Test
    public void siElAnimalEsPesado(){
        Animal caballo = new Animal("caballo", "grande", 500);
        Animal perro = new Animal("perro", "meadiano", 20);

        Assertions.assertTrue(caballo.esPesado());
        Assertions.assertFalse(perro.esPesado());
    }
}
