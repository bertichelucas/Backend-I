public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobarMail(Mail mail) {
        if (mail.getTema() == "tecnico"|| mail.getDestino() == "tecnica@colmena.com"){
            return "El correo se envio a tecnica";
        }
        if (this.getSiguienteManejador() != null){
            return this.getSiguienteManejador().comprobarMail(mail);
        }
        return null;
    }
}
