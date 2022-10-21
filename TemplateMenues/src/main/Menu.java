package main;

public abstract class Menu {

    private double precioBase;

    public Menu(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String ProcesoPrepararMenu(){
        String preparado = "";
        preparado  += this.armarMenu();

        preparado += this.calcularPrecio();
        return preparado;
    }

    public abstract String armarMenu();

    public abstract String calcularPrecio();

}
