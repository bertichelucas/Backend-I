import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrianguloTest {

    @Test
    public void TestTrianguloRojo2(){
        //GIVEN
        Triangulo t1 = TrianguloFactory.getTriangulo("rojo", 2);
        Triangulo t2 = TrianguloFactory.getTriangulo("rojo", 1);
        //WHEN

        //THEN
        Assertions.assertSame(t1, t2);
    }
}
