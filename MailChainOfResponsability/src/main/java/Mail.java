import lombok.Getter;

@Getter
public class Mail {

    private String origen,destino, tema;

    public Mail(String origen, String destino, String tema) {
        this.origen = origen;
        this.destino = destino;
        this.tema = tema;
    }
}
