public class Supermercado {

    public static void main(String[] args) {
        CalcDescuentoFacade fachada = new CalcDescuentoFacade();

        Tarjeta tarj = new Tarjeta("123123124", "Star Bank");
        Producto prod = new Producto("Gaseosa", "Bebida");
        int cantidad = 18;
        int descuentoTotal = fachada.calcularDescuento(tarj, prod, cantidad);
        System.out.println(descuentoTotal);
    }
}
