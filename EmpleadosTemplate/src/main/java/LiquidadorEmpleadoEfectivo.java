public class LiquidadorEmpleadoEfectivo extends Liquidador{
    @Override
    protected Double calcularSueldo(Empleado empleado) {
        if (empleado instanceof EmpleadoEfectivo){
            EmpleadoEfectivo emp = (EmpleadoEfectivo) empleado;
            return emp.getSueldoBasico() + emp.getPremios() - emp.getDescuentos();
        }
        return null;
    }

    @Override
    protected String emitirRecibo(Empleado empleado) {
        return "La liquidacion generada es un documento escrito.";
    }
}
