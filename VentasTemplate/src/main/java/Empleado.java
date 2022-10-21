public class Empleado extends Vendedor{

    private int aniosAntiguedad;
    private final int bonoPorAnio = 5;

    public Empleado(String nombre, int aniosAntiguedad) {
        super(nombre);
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public void conseguirAfiliado(){
        this.puntos += 10;
    }

    @Override
    public int calcularPuntos(){
        return this.puntos + this.aniosAntiguedad * bonoPorAnio;
    }

    @Override
    public void vender(){
        this.puntos += 5;
    }
}
