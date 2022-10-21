
public abstract class Vendedor {

    private String nombre;
    private String categoria;
    protected int puntos;

    public Vendedor(String nombre){
        this.nombre = nombre;
        this.categoria = "";
        this.puntos = 0;
    }

    public String mostrarCategoria(){
        int puntos = this.calcularPuntos();
        this.recategorizar(puntos);
        return this.toString();
    }

    public abstract int calcularPuntos();

    public void recategorizar(int puntos){
        if (puntos < 20) this.categoria = "novato";
        else if (puntos < 30) this.categoria = "aprendiz";
        else if (puntos < 40) this.categoria = "bueno";
        else this.categoria = "maestro";
    }

    public abstract void vender();

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", puntos=" + this.calcularPuntos() +
                '}';
    }
}
