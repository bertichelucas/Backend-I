import java.util.HashMap;
import java.util.Map;

public class TrianguloFactory {

    private static Map<String, Triangulo> mapTriangulos = new HashMap<>();


    public static Triangulo getTriangulo(String color, Integer tam){
        if (!mapTriangulos.containsKey(color)){
            mapTriangulos.put(color, new Triangulo(color, tam));
        }
        return  mapTriangulos.get(color);
    }
}
