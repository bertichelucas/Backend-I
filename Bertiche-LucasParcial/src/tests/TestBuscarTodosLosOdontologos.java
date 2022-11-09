package tests;

import dao.BD;
import dao.OdontologoIDao;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class TestBuscarTodosLosOdontologos {

    @Test
    @DisplayName("Test buscar todos los odontologos")
    public void buscarTodosLosOdontolgosTest(){
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
        List<Odontologo> odontologosList = os.buscarTodos();
        //THEN
        Assertions.assertTrue(odontologosList.size() == 3);
    }
}
