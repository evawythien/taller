package talleruned.gestionInterna;

public class Mensaje {

    protected int idMensaje;
    protected int idPromocion;
    protected String mensaje;

    public Mensaje(int idMensaje, int idPromocion, String mensaje) {
        this.idMensaje = idMensaje;
        this.idPromocion = idPromocion;
        this.mensaje = mensaje;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
