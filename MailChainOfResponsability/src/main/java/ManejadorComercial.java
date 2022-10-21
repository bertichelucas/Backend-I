public class ManejadorComercial extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        if (mail.getTema() == "comercial"|| mail.getDestino() == "comercial@colmena.com"){
            return "El correo se envio a comercial";
        }
        if (this.getSiguienteManejador() != null){
            return this.getSiguienteManejador().comprobarMail(mail);
        }
        return null;
    }
}
