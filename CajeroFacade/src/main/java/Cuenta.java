public class Cuenta {

    private String id;
    private String pass;
    private double saldo;

    public Cuenta(String id, String pass, double saldo) {
        this.id = id;
        this.pass = pass;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public double getSaldo() {
        return saldo;
    }
}
