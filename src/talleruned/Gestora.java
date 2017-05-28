package talleruned;

import talleruned.gestionInterna.FichaReparacion;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.NoSuchElementException;
import talleruned.gestionInterna.Estado;
import talleruned.usuarios.Cliente;
import talleruned.usuarios.Empleado;
import talleruned.vehiculos.Vehiculo;

public class Gestora {

    private HashMap<String, Cliente> clientes;
    private HashMap<String, Vehiculo> vehiculos;
    private HashMap<Integer, FichaReparacion> fichas;
    private HashMap<String, Empleado> empleados;
    private int idUltimaFicha;

    public Gestora() {
        this.clientes = new HashMap<>();
        this.vehiculos = new HashMap<>();
        this.fichas = new HashMap<>();
        this.empleados = new HashMap<>();
        this.empleados.put("1234", new Empleado("mecanico", "Paco", "Garcia", "Garcia", "1234", "Calle de abajo", 983666555, 633552244, Utilidades.getFecha(12, 12, 1960)));
        this.empleados.put("9876", new Empleado("mecanico", "Pepe", "Perez", "Perez", "9876", "Calle de arriba", 983666555, 633552244, Utilidades.getFecha(1, 1, 1989)));
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

        clientes = GestoraPersistencia.leerEnXML("clientes.xml");
        vehiculos = GestoraPersistencia.leerEnXML("vehiculos.xml");
        fichas = GestoraPersistencia.leerEnXML("fichas.xml");
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
    

    public void listadoFichasEnProceso(Estado e) {

    }

    public void listadoFichasPeriodo(Date fechaInicio, Date fechaFin) {

    }

    public void listadoFichasMecanico(Empleado empleado) {

    }

}
