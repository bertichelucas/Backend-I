import java.util.HashMap;

public class ComputadoraFactory {

    private static final HashMap<String, Computadora> computadoras = new HashMap<>();

    public static Computadora getComputadora(int ram, int disco){
        String key = "" + ram + ", " + disco;

        if (computadoras.get(key) == null){
            Computadora pc = new Computadora(ram, disco);
            computadoras.put(key, pc);
        }
        return computadoras.get(key);
    }
}
