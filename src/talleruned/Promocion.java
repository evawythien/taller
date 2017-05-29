package talleruned;

import java.util.Calendar;
import talleruned.tareas.Tarea;

public class Promocion {

    protected int idPromocion;
    protected String descripcion;
    protected Calendar fechaInicio;
    protected Calendar fechaFin;
    protected Float precio;
    protected Boolean soloUnTipoTarea;
    protected Tarea tareaValida;

    public Promocion(int idPromocion, String descripcion, Calendar fechaInicio, Calendar fechaFin, Float precio) {
        this.idPromocion = idPromocion;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.soloUnTipoTarea = false;
        this.tareaValida = Tarea.OTRA;
    }

    public Promocion(int idPromocion, String descripcion, Calendar fechaInicio, Calendar fechaFin, Float precio, Tarea tarea) {
        this(idPromocion, descripcion, fechaInicio, fechaFin, precio);
        this.soloUnTipoTarea = true;
        this.tareaValida = tarea;
    }

    public Boolean esPromocionValida(int idTarea, Calendar fecha) {

        if (soloUnTipoTarea) {
            return tareaValida.getIdTarea().equals(idTarea) && fechaInicio.before(fecha) && fechaFin.after(fecha);
        } else {
            return fechaInicio.before(fecha) && fechaFin.after(fecha);
        }
    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Boolean getSoloUnTipoTarea() {
        return soloUnTipoTarea;
    }

    public void setSoloUnTipoTarea(Boolean soloUnTipoTarea) {
        this.soloUnTipoTarea = soloUnTipoTarea;
    }

    public Tarea getTareaValida() {
        return tareaValida;
    }

    public void setTareaValida(Tarea tareaValida) {
        this.tareaValida = tareaValida;
    }

}
