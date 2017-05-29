package talleruned.tareas;

public class Tarea {

    private int idTarea;
    private String nombre;
    private Float coste;

    public Tarea(int idTarea, String nombre, Float coste) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.coste = coste;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCoste() {
        return coste;
    }

    public void setCoste(Float coste) {
        this.coste = coste;
    }

}
