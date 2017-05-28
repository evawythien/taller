package talleruned;

import java.util.Date;
public class Promocion {
    
    private int idPromocion;
    private String nombre;
    private Boolean ofertada;
    private Date fechaInicio;
    private Date fechaFin;
    private Double precio;
    private Date fechaOfertada;
    
    // Puesta a punto se oferta antes de los periodos vacacionales
// Semana Santa, Verano, Navidad
//Cambio de neumaticos
//Cambio de filtro
//Cambio de aceite

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getOfertada() {
        return ofertada;
    }

    public void setOfertada(Boolean ofertada) {
        this.ofertada = ofertada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaOfertada() {
        return fechaOfertada;
    }

    public void setFechaOfertada(Date fechaOfertada) {
        this.fechaOfertada = fechaOfertada;
    }

    public Promocion(int idPromocion, String nombre, Boolean ofertada, Date fechaInicio, Date fechaFin, Double precio, Date fechaOfertada) {
        this.idPromocion = idPromocion;
        this.nombre = nombre;
        this.ofertada = ofertada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.fechaOfertada = fechaOfertada;
    }   
    
}




