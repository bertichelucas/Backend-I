package main;

public class MenuInfantil extends Menu{

    private int cantJuguetes;
    private final double precioAdicionalPorJuguete = 3;

    public MenuInfantil(double precioBase, int cantJuguetes) {
        super(precioBase);
        this.cantJuguetes = cantJuguetes;
    }

    @Override
    public String armarMenu() {
        return "Menu infantil con " + this.cantJuguetes + "juguetes\n";
    }

    @Override
    public String calcularPrecio() {
        double precio = this.getPrecioBase() + this.cantJuguetes * this.precioAdicionalPorJuguete;
        return "Precio: " + precio;
    }
}
