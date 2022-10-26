import java.util.HashMap;

public class CuentaService {

    private HashMap<String, Cuenta> hashMap;

    public CuentaService(HashMap<String, Cuenta> hashMap) {
        this.hashMap = hashMap;
    }

    public Cuenta getCuenta(String id){
        return this.hashMap.get(id);
    }
}
