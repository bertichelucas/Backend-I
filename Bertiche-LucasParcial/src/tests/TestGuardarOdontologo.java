package tests;

import dao.BD;
import dao.OdontologoIDao;
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

        BD.crearTabla();
        OdontologoService os = new OdontologoService(new OdontologoIDao());
        Odontologo odontologo = new Odontologo("12312412", "Leo", "Messi");
        //WHEN
        Odontologo resultado = os.guardar(odontologo);

        //THEN
        Assertions.assertSame(odontologo, resultado);
        Assertions.assertEquals(odontologo.getId(), resultado.getId());
    }
}
