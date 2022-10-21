public abstract class Liquidador {

    public String liquidarSueldo(Empleado empleado){
        Double sueldo = calcularSueldo(empleado);
        if (sueldo > 0.0){
            String recibo = emitirRecibo(empleado);
            String deposito = depositarSueldo(empleado);
            return recibo + "Saldo a liquidar: " + sueldo;
        }
        return "No se pudo realizar liquidacion";
    }

    protected abstract Double calcularSueldo(Empleado empleado);

    protected abstract String emitirRecibo(Empleado empleado);

    private String depositarSueldo(Empleado empleado){
        return "Orden de deposito en la cuenta Nro: " + empleado.getCuentaBancaria();
    }

}
