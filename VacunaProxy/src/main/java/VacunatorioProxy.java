import java.util.Date;

public class VacunatorioProxy implements VacunatorioInterface {

    private Vacunatorio centroVacunatorio;

    public VacunatorioProxy(){
        this.centroVacunatorio = new Vacunatorio();
    }

    @Override
    public String vacunar(Persona persona) {
        Date hoy = new Date();
        if (hoy.after(persona.getFechaAsignada())){
            return this.centroVacunatorio.vacunar(persona);
        }
        return "Vacunación denegada";
    }
}
