import dao.BD;
import model.Medicamento;
import service.MedicamentoService;

public class Cliente {

    public static void main(String[] args) {
        //Necesito el service
        //Necesito crear las tablas
        //Necesito un medicamento para guardarlo

        MedicamentoService ms = new MedicamentoService();
        BD.crearTablas();
        Medicamento med = new Medicamento(1, "Paracetamol", "Pepito SRL", 1500, 200.0, 987481);

        ms.guardar(med);


    }
}
