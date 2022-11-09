import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

public class TestGuardarOdontologo {

    @Test
    @DisplayName("Test de guardado de un odontologo")
    public void guardarOdontologoTest(){
        //GIVEN

        BD.crearTablas();
        OdontologoService os = new OdontologoService(new OdontologoDAOH2());
        Odontologo odontologo = new Odontologo("12312412", "Leo", "Messi");
        //WHEN
        Odontologo resultado = os.guardar(odontologo);

        //THEN
        Assertions.assertSame(odontologo, resultado);
        Assertions.assertEquals(odontologo.getId(), resultado.getId());
    }
}