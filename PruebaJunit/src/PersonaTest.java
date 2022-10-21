import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(Parameterized.class)
public class PersonaTest {
    @Parameterized.Parameters
    public static Iterable data(){
        return Arrays.asList(new Object[][]{
                {"Lucas", 21},{"Pedro", 20}
        });
    }

    private String nombre;
    private int edad;

    public PersonaTest(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Test
    public void crearPersonaFunciona(){
        Persona p = new Persona(nombre, edad);
        Assert.assertEquals(nombre, p.getNombre());
        Assert.assertEquals(edad, p.getEdad());
    }
}

