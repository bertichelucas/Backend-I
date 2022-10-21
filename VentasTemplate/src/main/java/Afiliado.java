
public class Afiliado extends Vendedor{


    public Afiliado(String nombre) {
        super(nombre);
    }

    @Override
    public int calcularPuntos() {
        return this.puntos;
    }

    @Override
    public void vender(){
        this.puntos += 15;
    }
}
