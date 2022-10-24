import java.util.HashMap;

public class CancionFactory {

    private static final HashMap<String,Cancion> hashMap = new HashMap();

    public static Cancion getCancion(String nombreCancion){
        Cancion cancion = hashMap.get(nombreCancion);
        if (cancion == null){
            cancion = new Cancion(nombreCancion);
            hashMap.put(nombreCancion, cancion);
            System.out.println("Creo la cancion " + nombreCancion);
        }
        return cancion;
    }
}
