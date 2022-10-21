public abstract class Command {

    private Command siguienteCommand;

    public Command getSiguienteCommand() {
        return siguienteCommand;
    }

    public void setSiguienteCommand(Command siguienteCommand) {
        this.siguienteCommand = siguienteCommand;
    }

    public abstract String leerDocumento(Documento documento);
}
