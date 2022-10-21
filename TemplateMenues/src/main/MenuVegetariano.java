package main;

public class MenuVegetariano extends Menu{

    private int cantEspecias;
    private int cantSalsas;
    private final double precioAdicionalPorSalsa = 2;
    private final double porcentajeAdicionalPorEspecia = 0.01;

    public MenuVegetariano(double precioBase, int cantEspecias, int cantSalsas) {
        super(precioBase);
        this.cantEspecias = cantEspecias;
        this.cantSalsas = cantSalsas;
    }

    @Override
    public String armarMenu() {
        return "Menu Vegetariano con " + this.cantEspecias + " especias y " +
                this.cantSalsas + " salsas\n";
    }

    @Override
    public String calcularPrecio() {
        double precio = this.getPrecioBase() +
                        this.getPrecioBase() * this.porcentajeAdicionalPorEspecia * this.cantEspecias +
                        this.precioAdicionalPorSalsa * this.cantSalsas;
        return "Precio: " + precio;
    }
}