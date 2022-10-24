public class SerieProxy implements  ISerie{

    private int cantVisistas;
    private Serie serie;

    public SerieProxy() {
        this.cantVisistas = 0;
        this.serie = new Serie();
    }

    @Override
    public String getPelicula(String nombre) {
        if (cantVisistas > 5){
            return "Ha superado la cantidad de reproducciones permitidas";
        }
        cantVisistas++;
        return serie.getPelicula(nombre);
    }
}
