import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class GestionarContacto {

    public static void guardarListaContactos(List<Contacto> listaContactos, String archivo) throws Exception{

        FileOutputStream fos = new FileOutputStream(archivo);

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(listaContactos);

        oos.close();

    }

    public static List<Contacto> leerListaContactos(String archivo) throws Exception {
        List<Contacto> listaContactos = null;

        FileInputStream fis = new FileInputStream(archivo);

        ObjectInputStream ois = new ObjectInputStream(fis);

        listaContactos = (List<Contacto>) ois.readObject();

        return listaContactos;
    }



}
