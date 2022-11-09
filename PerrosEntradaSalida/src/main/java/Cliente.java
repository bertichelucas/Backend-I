import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    public static void main(String[] args) {

        //lista de perros

        List<Perro> listaPerros = new ArrayList<>();
        listaPerros.add(new Perro(1, "Duke"));
        listaPerros.add(new Perro(2, "Zeus"));
        listaPerros.add(new Perro(3, "Hera"));
        listaPerros.add(new Perro(4, "Taylor"));
        listaPerros.add(new Perro(5, "Rufus"));
        listaPerros.add(new Perro(6, "Batman"));
        listaPerros.add(new Perro(7, "Casco"));

        //guardar la lista en el disco

        FileOutputStream fos  =null;

        try {
            fos = new FileOutputStream("Salida.txt");
            //guardo la informacionusando ObjectOutputStream

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(listaPerros);
            oos.close();

        }catch (IOException ex){
            ex.printStackTrace();
        }

        //recuperar la informacion y mostrar por pantalla

        List<Perro> listaPerros2 = null;

        FileInputStream fis = null;

        try{
            fis = new FileInputStream("Salida.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            listaPerros2 = (ArrayList<Perro>) ois.readObject();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        for (Perro perro : listaPerros2) {
            System.out.println(perro);
        }

    }
}
