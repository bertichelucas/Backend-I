public class LiquidadorEmpleadoContratado extends Liquidador{


    @Override
    protected Double calcularSueldo(Empleado empleado) {
        if (empleado instanceof EmpleadoContratado){
            EmpleadoContratado emp  = (EmpleadoContratado) empleado;
            return emp.getCantidadHoras() * emp.getValorPorHora();
        }
        return null;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion generada es un documento digital";
    }
}
