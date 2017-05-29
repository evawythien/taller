package talleruned;

import java.util.Calendar;
import talleruned.gestionInterna.FichaReparacion;
import java.util.Scanner;
import talleruned.usuarios.Cliente;
import talleruned.usuarios.Empleado;
import talleruned.vehiculos.FactoriaVehiculos;
import talleruned.vehiculos.VehiculoCuatroRuedas;
import talleruned.vehiculos.MarcaVehiculo;
import talleruned.vehiculos.TipoCombustible;
import talleruned.vehiculos.TipoMoto;
import talleruned.vehiculos.TipoVehiculoProfesional;
import talleruned.vehiculos.Vehiculo;
import talleruned.vehiculos.VehiculoDosRuedas;

public class TallerUned {

    private static final Gestora gestora = new Gestora();
    private static Empleado empleado;
    //Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        gestora.obtenerDeXML();
        Scanner lector = new Scanner(System.in);

        System.out.println("Bienvenidos al taller ");
        String identificador;
        do {
            System.out.println("Introduzca su identificador:");
            identificador = lector.nextLine();
        } while ((empleado = gestora.getEmpleado(identificador)) == null);

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Gestión de fichas");
        System.out.println("2.- Gestión de vehiculos");
        System.out.println("3.- Gestion de clientes");
        int opcion = lector.nextInt();

        switch (opcion) {
            case 1:
                gestionFichas();
                System.out.flush(); // Limpiamos consola
                break;
            case 2:
                gestionVehiculos();
                System.out.flush(); // Limpiamos consola
                break;
            case 3:
                gestionClientes();
                System.out.flush(); // Limpiamos consola
                break;
        }
    }

    public static void gestionClientes() {

        Scanner lector = new Scanner(System.in);

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Añadir un nuevo cliente");
        System.out.println("2.- Modificar un cliente existente");
        System.out.println("3.- Ver listado de clientes");
        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                pedirDatosUsuario();
                break;
            case 2:
                editarCliente();
                break;
            case 3:
                System.out.println(gestora.listadoClientes());
                break;
        }
    }

    public static void gestionVehiculos() {

        Scanner lector = new Scanner(System.in);

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Añadir un nuevo vehículo");
        System.out.println("2.- Modificar un vehiculo existente");
        System.out.println("3.- Ver listado de vehiculos");
        int opcion = lector.nextInt();

        switch (opcion) {
            case 1:
                pedirDatosCoche(getDniExistente());
                break;
            case 2:
                editarCoche();
                break;
            case 3:
                gestora.listadoVehiculos();
                break;
        }
    }

    public static void gestionFichas() {

        Scanner lector = new Scanner(System.in);

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Mostrar listado de fichas");
        System.out.println("2.- Modificar ficha");
        System.out.println("3.- Mostrar fichas propias");
        int opcion = lector.nextInt();

        switch (opcion) {
            case 1:
                gestora.listadoFichas();
                break;
            case 2:
                editarFicha();
                break;
            case 3:
                gestora.listadoVehiculos();
                break;
        }
    }

    public static void pedirDatosUsuario() {

        Scanner lector = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.println("A continuación le vamos a pedir unos datos para la inscripción del taller");
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("1.- DNI:");
        String dni = lector.nextLine();
        if (ValidacionDatos.comprobarDni(dni)) {
            cliente.setDni(dni);
        }

        System.out.println("2.- Nombre:");
        cliente.setNombre(lector.nextLine());

        System.out.println("3.- Primer apellido:");
        cliente.setApellido(lector.nextLine());

        System.out.println("4.- Segundo apellido:");
        cliente.setApellidoDos(lector.nextLine());

        System.out.println("5.- Dirección:");
        cliente.setDireccion(lector.nextLine());

        System.out.println("6.- Teléfono movil:");
        cliente.setTlfMovil(lector.nextInt());
        lector.nextLine();

        System.out.println("7.- Teléfono fijo:");
        cliente.setTlfFijo(lector.nextInt());
        lector.nextLine();

        System.out.println("8.- Fecha de nacimiento(dd/mm/aaaa):");
        cliente.setFechaNacimiento(Utilidades.parseFecha(lector.nextLine()));

        gestora.guardarCliente(cliente);
        gestora.guardarEnXML();

    }

    public static void editarCliente() {

        Scanner lector = new Scanner(System.in);
        Cliente cliente;

        String identificador;
        do {
            System.out.println("1.- Introduzca un dni para modificar:");
            identificador = lector.nextLine();
            if ("".equals(identificador)) {
                return;
            }
        } while ((cliente = gestora.getCliente(identificador)) == null);

        System.out.println("2.- Nombre [" + cliente.getNombre() + "]:");
        String temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setNombre(temp);
        }

        System.out.println("3.- Primer apellido [" + cliente.getApellido() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setApellido(temp);
        }

        System.out.println("4.- Segundo apellido [" + cliente.getApellidoDos() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setApellidoDos(temp);
        }

        System.out.println("5.- Dirección [" + cliente.getDireccion() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setDireccion(temp);
        }

        System.out.println("6.- Teléfono movil [" + cliente.getTlfMovil() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setTlfMovil(Integer.parseInt(temp));
        }

        System.out.println("7.- Teléfono fijo [" + cliente.getDireccion() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setTlfFijo(Integer.parseInt(temp));
        }

        System.out.println("8.- Fecha de nacimiento(dd/mm/aaaa): ");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setFechaNacimiento(Utilidades.parseFecha(temp));
        }
        gestora.guardarCliente(cliente);
        gestora.guardarEnXML();

    }

    public static void pedirDatosCoche(String dni) {

        if (dni == null) {
            return;
        }

        Scanner lector = new Scanner(System.in);

        System.out.println("¿Cuántas ruedas posee su vehiculo?");
        int numeroRuedas = lector.nextInt();
        lector.nextLine();

        vehiculo.setDni(dni);

        String matricula;
        do {
            System.out.println("¿Cual es la matricula del vehiculo?");
            matricula = lector.nextLine();
            if ("".equals(matricula)) {
                return;
            }
        } while (!ValidacionDatos.comprobarMatricula(matricula));

        vehiculo.setMatricula(matricula);

        System.out.println("¿Cual es la marca del vehiculo? - Seleccione un número");
        for (MarcaVehiculo marca : MarcaVehiculo.values()) {
            System.out.println(marca.getKey() + ".- " + marca.getValue());
        }
        vehiculo.setMarca(MarcaVehiculo.getMarcaByKey(lector.nextInt()));
        lector.nextLine();

        System.out.println("¿Cual es el modelo?");
        vehiculo.setModelo(lector.nextLine());

        System.out.println("¿Pertenece a un servicio publico? - Responde Si o No");
        vehiculo.setPublico(lector.nextLine().equalsIgnoreCase("SI"));

        System.out.println("¿Que tipo de combustible utuliza? - Seleccione un número");
        for (TipoCombustible combustible : TipoCombustible.values()) {
            System.out.println(combustible.getKey() + ".- " + combustible.getValue());
        }
        vehiculo.setCombustible(TipoCombustible.getCombustibleByKey(lector.nextInt()));
        lector.nextLine();

        System.out.println("¿Tiene ABS? - Responde Si o No");
        vehiculo.setABS(lector.nextLine().equalsIgnoreCase("SI"));

        System.out.println("¿Caballos?");
        vehiculo.setCaballos(lector.nextFloat());
        lector.nextLine();

        System.out.println("¿Cilindrada?");
        vehiculo.setCilindrada(lector.nextFloat());
        lector.nextLine();

        System.out.println("¿Almacenamiento");
        vehiculo.setAlmacenamiento(lector.nextFloat());
        lector.nextLine();

        System.out.println("¿Tiene airbag? - Responde Si o No");
        vehiculo.setAirbag(lector.nextLine().equalsIgnoreCase("SI"));

        System.out.println("¿Tiene GPS integrado? - Responde Si o No");
        vehiculo.setGPS(lector.nextLine().equalsIgnoreCase("SI"));

        Vehiculo vehiculo = FactoriaVehiculos.crear(matricula, MarcaVehiculo.OTRAS, dni, numeroRuedas, Boolean.TRUE, dni, TipoCombustible.OTRO, Boolean.FALSE,
                numeroRuedas, numeroRuedas, numeroRuedas, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, numeroRuedas, numeroRuedas,
                Boolean.TRUE, Boolean.TRUE, TipoVehiculoProfesional.OTRO, TipoMoto.OTRO)
        
        gestora.guardarVehiculo(vehiculo);
        gestora.guardarEnXML();
    }

    public static void editarCoche() {

        Scanner lector = new Scanner(System.in);
        Vehiculo vehiculo = null;

        String matricula;
        do {
            System.out.println("1.- Introduzca una matricula para modificar:");
            matricula = lector.nextLine();
            if ("".equals(matricula)) {
                return;
            }
        } while ((vehiculo = gestora.getVehiculo(matricula)) == null);

        String temp;
        System.out.println("¿Cual es la marca del vehiculo? - Seleccione un número");
        for (MarcaVehiculo marca : MarcaVehiculo.values()) {
            System.out.println(marca.getKey() + ".- " + marca.getValue());
        }
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            vehiculo.setMarca(MarcaVehiculo.getMarcaByKey(Integer.parseInt(temp)));
        }

        System.out.println("¿Cual es el modelo?");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            vehiculo.setModelo(temp);
        }

        System.out.println("¿Pertenece a un servicio publico? - Responde Si o No");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            vehiculo.setPublico(temp.equalsIgnoreCase("SI"));
        }

        System.out.println("¿Que tipo de combustible utuliza? - Seleccione un número");
        for (TipoCombustible combustible : TipoCombustible.values()) {
            System.out.println(combustible.getKey() + ".- " + combustible.getValue());
        }
        vehiculo.setCombustible(TipoCombustible.getCombustibleByKey(Integer.parseInt(temp)));

        System.out.println("¿Tiene ABS? - Responde Si o No");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            vehiculo.setABS(temp.equalsIgnoreCase("SI"));
        }

        System.out.println("¿Caballos?");
        if (!"".equals(temp)) {
            vehiculo.setCaballos(Integer.parseInt(temp));
        }

        System.out.println("¿Cilindrada?");
        if (!"".equals(temp)) {
            vehiculo.setCilindrada(Integer.parseInt(temp));
        }

        System.out.println("¿Almacenamiento");
        if (!"".equals(temp)) {
            vehiculo.setAlmacenamiento(Integer.parseInt(temp));
        }

        System.out.println("¿Tiene airbag? - Responde Si o No");
        if (!"".equals(temp)) {
            vehiculo.setAirbag(temp.equalsIgnoreCase("SI"));
        }

        System.out.println("¿Tiene GPS integrado? - Responde Si o No");
        if (!"".equals(temp)) {
            vehiculo.setGPS(temp.equalsIgnoreCase("SI"));
        }

        gestora.guardarVehiculo(vehiculo);
        gestora.guardarEnXML();
    }

    public static void pedirDatosFichaReparación(String matricula, String dni, String dniEmpleado) {

        Scanner lector = new Scanner(System.in);
        FichaReparacion ficha = new FichaReparacion();

        System.out.println("Motivo de la visita:");
        ficha.setComentario(lector.nextLine());
        ficha.setDniCliente(dni);
        ficha.setMatricula(matricula);
        ficha.setDniEmpleado(dniEmpleado);
        ficha.setFecha(Utilidades.getFechaActual());

        gestora.guardarFichaReparacion(ficha);
        gestora.guardarEnXML();
    }

    public static void editarFicha() {

        Scanner lector = new Scanner(System.in);

    }

    public static String getDniExistente() {

        Scanner lector = new Scanner(System.in);
        String dni;

        do {
            System.out.println("Introduce el dni del cliente:");
            dni = lector.nextLine();
        } while (gestora.getCliente(dni) == null);

        return dni;
    }
}
