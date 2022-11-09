import dao.BD;
import dao.OdontologoDAOH2;
import model.Odontologo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

public class TestActualizarOdontologo {

    @Test
    @DisplayName("Test actualizar un odontologo")
    public void actualizarOdontologoTest(){
        //GIVEN

        BD.crearTablas();
        OdontologoService os = new OdontologoService(new OdontologoDAOH2());
        Odontologo od1 = new Odontologo("312312", "Juan", "Lopez");
        os.guardar(od1);

        //WHEN

        od1.setApellido("Martinez");
        od1.setNombre("Marcos");
        od1.setNumeroMatricula("23412");
        os.actualizar(od1);

        Odontologo res = os.buscar(1);
        //THEN
        Assertions.assertEquals(res.getId(), od1.getId());
        Assertions.assertEquals(res.getNumeroMatricula(), od1.getNumeroMatricula());
        Assertions.assertEquals(res.getNombre(), od1.getNombre());
        Assertions.assertEquals(res.getApellido(), od1.getApellido());
    }
}
