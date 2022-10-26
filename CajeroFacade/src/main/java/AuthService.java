import java.util.HashMap;
import java.util.List;

public class AuthService {

    private HashMap<String, Cuenta> hashMap;

    public AuthService(HashMap<String, Cuenta> hashMap) {
        this.hashMap = hashMap;
    }

    public boolean validarUsuarioPassword(String id, String pass){
        if(this.hashMap.get(id) != null){
            return this.hashMap.get(id).getPass() == pass;
        }
        return false;
    }
}
