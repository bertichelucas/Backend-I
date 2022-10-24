public interface IgrillaDePeliculas {

    public abstract Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException;
}
