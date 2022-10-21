package main;

public class MenuClasico extends Menu{


    public MenuClasico(double precioBase) {
        super(precioBase);
    }

    @Override
    public String armarMenu() {
        return "Menu Clasico\n";
    }

    @Override
    public String calcularPrecio() {
        return "Precio: " + this.getPrecioBase();
    }
}
