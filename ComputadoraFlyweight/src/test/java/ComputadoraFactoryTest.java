import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputadoraFactoryTest {

    @Test
    void test1(){
        //GIVEN

        //WHEN
        Computadora pc = ComputadoraFactory.getComputadora(16, 500);
        Computadora pc2 = ComputadoraFactory.getComputadora(16, 500);
        //THEN
        Assertions.assertSame(pc, pc2);
    }
}
