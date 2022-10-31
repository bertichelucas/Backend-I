import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class App {

    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App(){
        this.listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer numero){
        this.listaEnteros.add(numero);
        if (listaEnteros.size() > 5){
            logger.info("La lista tiene mas de 5 elementos: " + listaEnteros.size());
        }
        if (listaEnteros.size() > 10){
            logger.info("La lista tiene mas de 10 elementos: "  + listaEnteros.size());
            listaEnteros.s
        }
    }
}
