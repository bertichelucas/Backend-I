import java.util.ArrayList;
import java.util.List;

public class Bosque {

    private List<Arbol> listaArboles;

    public Bosque(){
        this.listaArboles = new ArrayList<>();
    }

    public void plantarArbol(String tipo){
        switch (tipo){
            case "floral": listaArboles.add(ArbolFactory.getArbol(100, 200, "celeste"));
            case "frutal": listaArboles.add(ArbolFactory.getArbol(500,300, "rojo"));
            default: listaArboles.add(ArbolFactory.getArbol(200, 400, "verde"));

        }
    }

    public String mostrarArboles(){
        return this.listaArboles.toString();
    }
}
