import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        List<Contacto> listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto("carlos", "carlos@gmail.com", "12312412"));
        listaContactos.add(new Contacto("juan", "juan@gmail.com", "42142"));
        listaContactos.add(new Contacto("martin", "martin@gmail.com", "3232"));

        try {
            GestionarContacto.guardarListaContactos(listaContactos, "lista.txt");
            List<Contacto> lista = GestionarContacto.leerListaContactos("lista.txt");

            for (Contacto con: lista) {
                System.out.println(con);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
