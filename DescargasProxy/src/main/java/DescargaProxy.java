public class DescargaProxy implements DescargaInterface{

    private DescargaService descarga;

    public DescargaProxy(){
        this.descarga = new DescargaService();
    }

    @Override
    public boolean descargar(Usuario usuario) {
        if (usuario.getTipoUsuario() == "Premium"){
            return descarga.descargar(usuario);
        }
        return false;
    }
}
