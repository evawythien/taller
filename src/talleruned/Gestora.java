package talleruned;

import java.util.ArrayList;
import talleruned.gestionInterna.FichaReparacion;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import talleruned.gestionInterna.Estado;
import talleruned.gestionInterna.Mensaje;
import talleruned.tareas.Tarea;
import talleruned.usuarios.Cliente;
import talleruned.usuarios.Empleado;
import talleruned.vehiculos.MarcaVehiculo;
import talleruned.vehiculos.TipoCombustible;
import talleruned.vehiculos.Vehiculo;

public class Gestora {

    private final HashMap<String, Cliente> clientes;
    private HashMap<String, Vehiculo> vehiculos;
    private HashMap<Integer, FichaReparacion> fichas;
    private HashMap<String, Empleado> empleados;
    private HashMap<Integer, Promocion> promociones;
    private HashMap<Integer, Mensaje> mensajes;
    private HashMap<Integer, Tarea> tareas;
    private int idUltimaFicha;

    public Gestora() {

        this.clientes = new HashMap<>();
        this.vehiculos = new HashMap<>();
        this.fichas = new HashMap<>();
        this.empleados = new HashMap<>();
        this.promociones = new HashMap<>();
        this.tareas = new HashMap<>();
        this.mensajes = new HashMap<>();
        this.empleados.put("1234", new Empleado("mecanico", "Paco", "Garcia", "Garcia", "1234", "Calle de abajo", 983666555, 633552244, Utilidades.getFecha(12, 12, 1960)));
        this.empleados.put("9876", new Empleado("mecanico", "Pepe", "Perez", "Perez", "9876", "Calle de arriba", 983666555, 633552244, Utilidades.getFecha(1, 1, 1989)));
        this.tareas.put(0, new Tarea(0, "Otra", 300.f));
        this.tareas.put(1, new Tarea(1, "Revisión filtro de particulas", 200.f));
        this.tareas.put(2, new Tarea(2, "Revisión de sirena", 40.f));
        this.tareas.put(3, new Tarea(3, "Revisión presion neumáticos", 10.f));
        this.tareas.put(4, new Tarea(4, "Revisión aceite", 30.f));
        this.tareas.put(5, new Tarea(5, "Revisión técnica (ITV)", 300.f));
        this.tareas.put(6, new Tarea(6, "Revisión pre ITV", 0.f));
        this.tareas.put(7, new Tarea(7, "Llevar coche ITV", 0.f));
        this.tareas.put(8, new Tarea(8, "Reparaciones adicionales", 0.f));
        this.tareas.put(9, new Tarea(9, "Puesta a punto", 150.f));
        this.tareas.put(10, new Tarea(10, "Cambio neumaticos", 500.f));
        this.promociones.put(1, new Promocion(1, 9, "Puesta a punto periodo Semana Santa", Utilidades.getFecha(1, 4, 2017), Utilidades.getFecha(30, 4, 2017), 100.f));
        this.promociones.put(2, new Promocion(2, 9, "Puesta a punto periodo Verano", Utilidades.getFecha(1, 2, 2017), Utilidades.getFecha(30, 9, 2017), 90.f));
        this.promociones.put(3, new Promocion(3, 9, "Puesta a punto periodo Navidad", Utilidades.getFecha(1, 12, 2017), Utilidades.getFecha(5, 1, 2018), 110.f));
        this.promociones.put(4, new Promocion(4, 10, "Promoción cambio de neumaticos", Utilidades.getFecha(1, 2, 2017), Utilidades.getFecha(31, 3, 2017), 400.f));
        this.promociones.put(5, new Promocion(5, 1, "Promoción cambio de filtro", Utilidades.getFecha(1, 10, 2017), Utilidades.getFecha(31, 10, 2017), 150.f));
        this.promociones.put(6, new Promocion(6, 4, "Promoción cambio de aceite", Utilidades.getFecha(1, 11, 2017), Utilidades.getFecha(30, 11, 2017), 20.f));
        this.mensajes.put(1, new Mensaje(1, 1, "¿Le gustaría aceptar a la promoción actual de 'Puesta a punto periodo Semana Santa'?"));
        this.mensajes.put(2, new Mensaje(2, 2, "¿Le gustaría aceptar a la promoción actual de 'Puesta a punto periodo Verano'?"));
        this.mensajes.put(3, new Mensaje(3, 3, "¿Le gustaría aceptar a la promoción actual de 'Puesta a punto periodo Navidad'?"));
        this.mensajes.put(4, new Mensaje(4, 4, "¿Le gustaría aceptar a la promoción actual de 'Promoción cambio de neumaticos'?"));
        this.mensajes.put(5, new Mensaje(5, 5, "¿Le gustaría aceptar a la promoción actual de 'Promoción cambio de filtro'?"));
        this.mensajes.put(6, new Mensaje(6, 6, "¿Le gustaría aceptar a la promoción actual de 'Promoción cambio de aceite'?"));

    }

    public void guardarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public Cliente getCliente(String dni) {
        return clientes.get(dni);
    }

    public void guardarEnXML() {

        GestoraPersistencia.escribirXML("clientes.xml", clientes);
        GestoraPersistencia.escribirXML("vehiculos.xml", vehiculos);
        GestoraPersistencia.escribirXML("fichas.xml", fichas);
    }

    public void obtenerDeXML() {

        clientes.putAll(GestoraPersistencia.leerEnXML("clientes.xml"));
        vehiculos.putAll(GestoraPersistencia.leerEnXML("vehiculos.xml"));
        fichas.putAll(GestoraPersistencia.leerEnXML("fichas.xml"));
        if (!fichas.isEmpty()) {
            idUltimaFicha = Collections.max(fichas.keySet());
        }
    }

    public Empleado getEmpleado(String dni) {
        return empleados.get(dni);
    }

    public void guardarVehiculo(Vehiculo vehiculo) {
        vehiculos.put(vehiculo.getMatricula(), vehiculo);
    }

    public Vehiculo getVehiculo(String matricula) {
        return vehiculos.get(matricula);
    }

    public FichaReparacion getFichaReparacion(int idFicha) {
        return fichas.get(idFicha);
    }

    public List<FichaReparacion> getFichasReparacionPorEmpleado(String dniEmpleado) {
        List<FichaReparacion> fichasReparacion = new ArrayList<>();
        for (FichaReparacion ficha : fichas.values()) {
            if (ficha.getDniEmpleado().equals(dniEmpleado)) {
                fichasReparacion.add(ficha);
            }
        }
        return fichasReparacion;
    }

    // Devuelve todas las fichas de reparación que se encuenten en un estado diferente a terminado5
    public List<FichaReparacion> getFichasReparacionEnProceso() {
        List<FichaReparacion> fichasReparacion = new ArrayList<>();
        for (FichaReparacion ficha : fichas.values()) {
            if (!ficha.getEstado().equals(Estado.TERMINADO)) {
                fichasReparacion.add(ficha);
            }
        }
        return fichasReparacion;
    }

    public List<FichaReparacion> getFichasReparacionPorEstado(Estado estado) {
        List<FichaReparacion> fichasReparacion = new ArrayList<>();
        for (FichaReparacion ficha : fichas.values()) {
            if (ficha.getEstado().equals(estado)) {
                fichasReparacion.add(ficha);
            }
        }
        return fichasReparacion;
    }

    public List<FichaReparacion> getFichasReparacionEntreFechas(String fechaInicio, String fechaFin) {
        List<FichaReparacion> fichasReparacion = new ArrayList<>();
        for (FichaReparacion ficha : fichas.values()) {
            if (ficha.getFecha().before(Utilidades.parseFecha(fechaFin)) && ficha.getFecha().after(Utilidades.parseFecha(fechaInicio))) {
                fichasReparacion.add(ficha);
            }
        }
        return fichasReparacion;
    }

    public void guardarFichaReparacion(FichaReparacion ficha) {
        ficha.setIdFicha(++idUltimaFicha);
        fichas.put(ficha.getIdFicha(), ficha);
    }

    public String listadoClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes.values()) {
            sb.append(c).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String listadoVehiculos() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo c : vehiculos.values()) {
            sb.append(c).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String listadoVehiculosCliente(String dni) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo c : vehiculos.values()) {
            if (c.getDni().equals(dni)) {
                sb.append(c).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String listadoVehiculosPorCombustible(TipoCombustible combustible) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo c : vehiculos.values()) {
            if (c.getCombustible().equals(combustible)) {
                sb.append(c).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String listadoVehiculosPorMarca(MarcaVehiculo marca) {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo c : vehiculos.values()) {
            if (c.getMarca().equals(marca)) {
                sb.append(c).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String listadoFichas() {
        StringBuilder sb = new StringBuilder();
        for (FichaReparacion c : fichas.values()) {
            sb.append(c).append(System.lineSeparator());
        }
        return sb.toString();
    }

    // Muestra las promociones que estan activas en la fecha actual
    public String listadoPromocionesActivas() {
        StringBuilder sb = new StringBuilder();
        for (Promocion c : promociones.values()) {
            if (Utilidades.isPromoBetweenDates(c.getFechaInicio(), c.getFechaFin())) {
                sb.append(c).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
