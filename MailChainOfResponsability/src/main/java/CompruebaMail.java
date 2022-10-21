public class CompruebaMail {

    private Manejador cadena;

    public CompruebaMail() {
        this.cadena = new ManejadorGerencial();
        Manejador comercial  = new ManejadorComercial();
        Manejador tecnica = new ManejadorTecnico();
        Manejador spam = new ManejadorSpam();

        cadena.setSiguienteManejador(comercial);
        comercial.setSiguienteManejador(tecnica);
        tecnica.setSiguienteManejador(spam);
    }

    public String checkCorreo(Mail mail){
        return cadena.comprobarMail(mail);
    }
}
