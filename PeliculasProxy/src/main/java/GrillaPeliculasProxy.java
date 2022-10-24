public class GrillaPeliculasProxy implements IgrillaDePeliculas{

    private IP ip;
    private GrillaPelicula grillaPeli;

    @Override
    public Pelicula getPelicula(String nombrePelicula)throws PeliculaNoHabilitadaException {
        Pelicula pelicula = this.grillaPeli.getPelicula(nombrePelicula);
        if (pelicula.pais() == ip.getPais()){
            return pelicula;
        }
        throw new PeliculaNoHabilitadaException("No disponible en el pais");
    }
}
