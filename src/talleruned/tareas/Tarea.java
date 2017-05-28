package talleruned.tareas;

public class Tarea {

    private String nombre;
    private String descripción;
    private Double coste;
    private int especifica;

    /*REVISAR_FILTRO_PARTICULAS, 
    REVISION_SIRENA, 
    PRESION_NEUMARICOS, 
    ACEITE,*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Double getCoste() {
        return coste;
    }

    public void setCoste(Double coste) {
        this.coste = coste;
    }

    public Tarea(String nombre, String descripción, Double coste) {
        this.nombre = nombre;
        this.descripción = descripción;
        this.coste = coste;
    }

}
