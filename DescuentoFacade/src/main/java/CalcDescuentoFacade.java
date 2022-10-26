public class CalcDescuentoFacade implements ICalcDescuento{


    @Override
    public int calcularDescuento(Tarjeta tarjeta, Producto prod, int cantidad) {


        return  ApiTarjeta.descuentoXTarjeta(tarjeta) + ApiProducto.descuentoXProducto(prod) +
                ApiCantidad.descuentoXCantidad(cantidad);
    }
}
