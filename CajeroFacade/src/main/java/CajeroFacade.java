public class CajeroFacade implements ICajeroFacade{

    private AuthService authService;
    private CuentaService cuentaService;
    private CajaService cajaService;

    public CajeroFacade() {
        
        this.authService = new AuthService();
        this.cuentaService = new CuentaService();
        this.cajaService = new CajaService();
    }

    @Override
    public String retirarDinero(String id, String pass, double saldo) {
        if (this.authService.validarUsuarioPassword(id, pass)){
            Cuenta cuenta = this.cuentaService.getCuenta(id);
            if (cuenta != null){
                if (cuenta.getSaldo() >= saldo){
                    return this.cajaService.entregarDinero(saldo);
                }
            }
        }
        return "No se ha podido retirar el dinero";
    }
}
