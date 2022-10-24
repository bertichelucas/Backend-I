import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {

    private String nombre;
    private List<Cancion> canciones;

    public ListaReproduccion(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<Cancion>();

    }

    public void agregarCancion(String nombre){
        canciones.add(CancionFactory.getCancion(nombre));
    }

    @Override
    public String toString() {
        ArrayList<Cancion> miArray = (ArrayList)canciones;
        String rta ="ListaReproduccion{" +
                "nombre='" + nombre + '\n';
        for (int i = 0; i <miArray.size(); i++){
            rta += i + miArray.get(i).getNombre() + '\n';
        }
        return rta;
    }
}
