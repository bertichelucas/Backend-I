public class Documento {

    private String contenido;
    private int tipo;

    public Documento(String contenido, int tipo) {
        this.contenido = contenido;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
