package tests;

import dao.BD;
import dao.OdontologoIDao;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class TestBuscarPorID {
    @Test
    @DisplayName("Test buscar un odontologo por id")
    public void buscarOdontologoPorIdTest(){
        //GIVEN

        BD.crearTabla();
        OdontologoService os = new OdontologoService(new OdontologoIDao());
        Odontologo od1 = new Odontologo("312312", "Juan", "Lopez");
        Odontologo od2 = new Odontologo("634656", "Martin", "Cramer");
        Odontologo od3 = new Odontologo("31232312", "Pablo", "Picasso");
        os.guardar(od1);
        os.guardar(od2);
        os.guardar(od3);

        //WHEN
        Odontologo odEsperado = os.buscar(1);
        //THEN
        Assertions.assertEquals(od1.getId(), odEsperado.getId());
    }
}
