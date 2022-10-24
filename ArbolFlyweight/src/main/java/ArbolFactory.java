import java.util.HashMap;

public class ArbolFactory {

    private static final HashMap<String, Arbol> arbolesCache = new HashMap<>();

    public static Arbol getArbol(int alto, int ancho, String color){

        if (arbolesCache.get(color) == null){
            arbolesCache.put(color, new Arbol(alto, ancho, color));
        }
        return arbolesCache.get(color);
    }
}
