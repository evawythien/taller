package talleruned.tareas;

import talleruned.vehiculos.TipoCombustible;

public enum Tarea {

    OTRA(0, "Otra", 300.f),
    FITRO_PARTICULAS(1, "Revisión filtro de particulas", 200.f),
    REVISION_SIRENA(2, "Revisión de sirena", 40.f),
    REVISION_NEUMATICOS(3, "Revisión presion neumáticos", 10.f),
    REVISION_ACEITE(4, "Revisión aceite", 30.f),
    REVISION_ITV(5, "Revisión técnica (ITV)", 300.f),
    REVISION_PRE_ITV(6, "Revisión pre ITV", 0.f),
    LLEVAR_ITV(7, "Llevar coche ITV", 0.f),
    REVISIO_ADICIONAL(8, "Reparaciones adicionales", 0.f),
    PUESTA_A_PUNTO(9, "Puesta a punto", 150.f),
    CAMBIO_NEUMATICOS(10, "Cambio neumaticos", 500.f);

    private final Integer idTarea;
    private final String nombre;
    private final Float coste;

    Tarea(Integer idTarea, String nombre, Float coste) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.coste = coste;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public Float getCoste() {
        return coste;
    }

    public static Tarea getTareaByKey(int id) {
        for (Tarea t : Tarea.values()) {
            if (t.getIdTarea() == id) {
                return t;
            }
        }
        return Tarea.OTRA;
    }

}
