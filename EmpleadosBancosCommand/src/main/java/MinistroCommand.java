public class MinistroCommand extends Command{

    @Override
    public String leerDocumento(Documento documento) {
        if (documento.getTipo() <= 2){
            return "Leido por el ministro";
        }
        return this.getSiguienteCommand().leerDocumento(documento);
    }
}
