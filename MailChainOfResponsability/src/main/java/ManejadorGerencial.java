public class ManejadorGerencial extends Manejador{


    @Override
    public String comprobarMail(Mail mail) {
        if (mail.getTema() == "gerencial"|| mail.getDestino() == "gerencial@colmena.com"){
            return "El correo se envio a gerencial";
        }
        if (this.getSiguienteManejador() != null){
            return this.getSiguienteManejador().comprobarMail(mail);
        }
        return null;
    }
}
