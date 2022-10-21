public class DiputadoCommand extends Command{

    @Override
    public String leerDocumento(Documento documento) {
        if(documento.getTipo() <= 1) {
            return "Leido por el diputado";
        }
        return this.getSiguienteCommand().leerDocumento(documento);

    }
}
