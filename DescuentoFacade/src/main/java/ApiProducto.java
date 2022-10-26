public class ApiProducto {

    public static int descuentoXProducto(Producto p){

        if (p.tipo().equals("Latas")){
            return 10;
        }
        return 0;
    }
}
