public class ApiTarjeta {

    public static int descuentoXTarjeta(Tarjeta tarjeta){
        if (tarjeta.banco().equals("Star Bank")){
            return 20;
        }
        return 0;
    }
}
