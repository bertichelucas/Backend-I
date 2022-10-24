import org.junit.jupiter.api.Test;

public class TestBosque {

    @Test
    public void testeoBosque100Arboles(){
        //GIVEN
        String[] lista = {"floral", "frutal", "ornamental"};
        Bosque bsq = new Bosque();

        //WHEN
        for (int i = 0; i < 100; i++){
            bsq.plantarArbol(lista[i%3]);
        }

        //THEN
        System.out.println(bsq.mostrarArboles());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));



    }
}
