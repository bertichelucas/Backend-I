public class Vacunatorio implements VacunatorioInterface{
    @Override
    public String vacunar(Persona persona) {
        return "DNI: " + persona.getDni() + ", vacunado con: " + persona.getNombreVacuna();
    }
}
