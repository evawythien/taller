package talleruned;

import talleruned.gestionInterna.FichaReparacion;
import java.util.Scanner;
import talleruned.gestionInterna.Estado;
import talleruned.tareas.Tarea;
import talleruned.usuarios.Cliente;
import talleruned.usuarios.Empleado;
import talleruned.vehiculos.FactoriaVehiculos;
import talleruned.vehiculos.MarcaVehiculo;
import talleruned.vehiculos.TipoCombustible;
import talleruned.vehiculos.TipoMoto;
import talleruned.vehiculos.TipoVehiculoProfesional;
import talleruned.vehiculos.Vehiculo;
import talleruned.vehiculos.VehiculoCuatroRuedas;
import talleruned.vehiculos.VehiculoProfesional;

public class TallerUned {

    private static final Gestora gestora = new Gestora();
    private static Empleado empleado;
    private static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {

        gestora.obtenerDeXML();

        System.out.println("Bienvenidos al taller ");
        String identificador;
        do {
            System.out.println("Introduzca su identificador:");
            identificador = lector.nextLine();
        } while ((empleado = gestora.getEmpleado(identificador)) == null);

        while (true) {
            System.out.println("¿Que quiere hacer?:");
            System.out.println("0.- Salir");
            System.out.println("1.- Gestión de fichas");
            System.out.println("2.- Gestión de vehiculos");
            System.out.println("3.- Gestion de clientes");
            System.out.println("4.- Crear ficha");
            System.out.println("5.- Búsquedas");
            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    gestionFichas();
                    break;
                case 2:
                    gestionVehiculos();
                    break;
                case 3:
                    gestionClientes();
                    break;
                case 4:
                    realizarBusquedas();
                    break;
                case 5:
                    pedirDatosFichaReparación();
                    break;
            }
        }
    }

    public static void gestionClientes() {

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Añadir un nuevo cliente");
        System.out.println("2.- Modificar un cliente existente");
        System.out.println("3.- Ver listado de clientes");
        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                pedirDatosUsuario(null);
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

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Añadir un nuevo vehículo.");
        System.out.println("2.- Modificar un vehiculo existente.");
        System.out.println("3.- Ver listado de vehiculos.");
        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                pedirDatosCoche(getDniExistente(), null);
                break;
            case 2:
                editarCoche();
                break;
            case 3:
                System.out.println(gestora.listadoVehiculos());
                break;
        }
    }

    public static void gestionFichas() {

        System.out.println("¿Que quiere hacer?:");
        System.out.println("1.- Mostrar listado de fichas.");
        System.out.println("2.- Modificar ficha.");
        System.out.println("3.- Mostrar fichas empleado.");
        System.out.println("4.- Mostrar fichas en proceso.");
        System.out.println("5.- Mostrar fichas entre las fechas:");
        int opcion = lector.nextInt();
        lector.nextLine();

        switch (opcion) {
            case 1:
                System.out.println(gestora.listadoFichas());
                break;
            case 2:
                editarFicha();
                break;
            case 3:
                System.out.println(gestora.getFichasReparacionPorEmpleado(getDniExistente()));
                break;
            case 4:
                gestora.getFichasReparacionEnProceso();
                break;
            case 5:
                System.out.println("-- Fecha inicial: (dd/mm/aaaa):");
                String fechaInicio = lector.nextLine();
                System.out.println("-- Fecha fin: (dd/mm/aaaa):");
                String fechaFin = lector.nextLine();
                gestora.getFichasReparacionEntreFechas(fechaInicio, fechaFin);
                break;
        }
    }

    public static void pedirDatosUsuario(String dni) {

        Cliente cliente = new Cliente();
        System.out.println("A continuación le vamos a pedir unos datos para la inscripción del taller");
        System.out.println("-------------------------------------------------------------------------");

        if (dni == null) {
            System.out.println("1.- DNI:");
            dni = lector.nextLine();
            if (ValidacionDatos.comprobarDni(dni)) {
                cliente.setDni(dni);
            }
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

        System.out.println("7.- Teléfono fijo [" + cliente.getTlfFijo() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setTlfFijo(Integer.parseInt(temp));
        }

        System.out.println("8.- Fecha de nacimiento(dd/mm/aaaa) [" + Utilidades.formatFecha(cliente.getFechaNacimiento()) + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cliente.setFechaNacimiento(Utilidades.parseFecha(temp));
        }
        gestora.guardarCliente(cliente);
        gestora.guardarEnXML();

    }

    public static void pedirDatosCoche(String dni, String matricula) {

        if (dni == null) {
            return;
        }

        System.out.println("¿Cuántas ruedas posee su vehiculo?");
        int numeroRuedas = lector.nextInt();
        lector.nextLine();

        if (matricula == null) {
            do {
                System.out.println("¿Cual es la matricula del vehiculo?");
                matricula = lector.nextLine();
                if ("".equals(matricula)) {
                    return;
                }
            } while (!ValidacionDatos.comprobarMatricula(matricula));
        }

        Boolean profesional = false;
        TipoVehiculoProfesional tipoVehiculoPro = TipoVehiculoProfesional.OTRO;

        if (numeroRuedas == 4) {
            System.out.println("¿Pertenece a un servicio publico? - Responde Si o No");
            profesional = lector.nextLine().equalsIgnoreCase("SI");

            if (profesional) {
                System.out.println("¿De que tipo es? - Seleccione un número");
                for (TipoVehiculoProfesional marca : TipoVehiculoProfesional.values()) {
                    System.out.println(marca.getKey() + ".- " + marca.getValue());
                }
                tipoVehiculoPro = TipoVehiculoProfesional.getVehiculoProfesionalByKey(lector.nextInt());
                lector.nextLine();
            }
        }

        System.out.println("¿Cual es la marca del vehiculo? - Seleccione un número");
        for (MarcaVehiculo marca : MarcaVehiculo.values()) {
            System.out.println(marca.getKey() + ".- " + marca.getValue());
        }
        MarcaVehiculo marca = MarcaVehiculo.getMarcaByKey(lector.nextInt());
        lector.nextLine();

        System.out.println("¿Cual es el modelo?");
        String modelo = lector.nextLine();

        System.out.println("¿Que tipo de combustible utiliza? - Seleccione un número");
        for (TipoCombustible combustible : TipoCombustible.values()) {
            System.out.println(combustible.getKey() + ".- " + combustible.getValue());
        }
        TipoCombustible tipoCombustible = TipoCombustible.getCombustibleByKey(lector.nextInt());
        lector.nextLine();

        System.out.println("¿Tiene ABS? - Responde Si o No");
        Boolean abs = lector.nextLine().equalsIgnoreCase("SI");

        System.out.println("¿Caballos?");
        float caballos = lector.nextFloat();
        lector.nextLine();

        System.out.println("¿Cilindrada?");
        float cilindrada = lector.nextFloat();
        lector.nextLine();

        System.out.println("¿Almacenamiento?");
        float almacenamiento = lector.nextFloat();
        lector.nextLine();

        System.out.println("¿Tiene airbag? - Responde Si o No");
        Boolean airbag = lector.nextLine().equalsIgnoreCase("SI");

        System.out.println("¿Tiene GPS integrado? - Responde Si o No");
        Boolean gps = lector.nextLine().equalsIgnoreCase("SI");

        TipoMoto tipoMoto = TipoMoto.OTRO;

        Boolean descapotable = false;
        Boolean climatizado = false;
        int numPasajeros = 0;
        int numPuertas = 0;
        Boolean aireAcondicionado = false;

        if (numeroRuedas == 2) {

            System.out.println("¿De que tipo es? - Seleccione un número");
            for (TipoMoto tipo : TipoMoto.values()) {
                System.out.println(tipo.getKey() + ".- " + tipo.getValue());
            }
            tipoMoto = TipoMoto.getTipoMotoByKey(lector.nextInt());
            lector.nextLine();

        } else if (numeroRuedas == 4) {

            System.out.println("¿Es descapotable? - Responde Si o No");
            descapotable = lector.nextLine().equalsIgnoreCase("SI");

            System.out.println("¿Es climatizado? - Responde Si o No");
            climatizado = lector.nextLine().equalsIgnoreCase("SI");

            System.out.println("¿Cuántos pasajeros entran enº su vehiculo?");
            numPasajeros = lector.nextInt();
            lector.nextLine();

            System.out.println("¿Cuántas puertas posee su vehiculo?");
            numPuertas = lector.nextInt();
            lector.nextLine();

            System.out.println("¿Tiene aire acondicionado? - Responde Si o No");
            aireAcondicionado = lector.nextLine().equalsIgnoreCase("SI");
        }

        Vehiculo vehiculo = FactoriaVehiculos.crear(matricula, marca, modelo, numeroRuedas, profesional, dni,
                tipoCombustible, abs, caballos, cilindrada, almacenamiento, airbag, gps, descapotable,
                climatizado, numPasajeros, numPuertas, aireAcondicionado, tipoVehiculoPro, tipoMoto);

        gestora.guardarVehiculo(vehiculo);
        gestora.guardarEnXML();
    }

    public static void editarCoche() {

        Vehiculo vehiculoOriginal = null;
        String temp = null;

        String matricula;
        do {
            System.out.println("1.- Introduzca una matricula para modificar:");
            matricula = lector.nextLine();
            if ("".equals(matricula)) {
                return;
            }
        } while ((vehiculoOriginal = gestora.getVehiculo(matricula)) == null);

        int numeroRuedas = vehiculoOriginal.getNumeroRuedas();
        System.out.println("¿Cuántas ruedas posee su vehiculo? [" + numeroRuedas + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            numeroRuedas = Integer.parseInt(temp);
        }

        Boolean profesional = false;
        TipoVehiculoProfesional tipoVehiculoPro = TipoVehiculoProfesional.OTRO;

        if (numeroRuedas == 4) {
            System.out.println("¿Pertenece a un servicio publico? - Responde Si o No");
            profesional = lector.nextLine().equalsIgnoreCase("SI");

            if (profesional) {

                VehiculoProfesional vp = vehiculoOriginal instanceof VehiculoProfesional ? (VehiculoProfesional) vehiculoOriginal : null;
                if (vp != null) {
                    tipoVehiculoPro = vp.getTipo();
                }

                System.out.println("¿De que tipo es? - Seleccione un número [" + tipoVehiculoPro.getKey() + ".- " + tipoVehiculoPro.getValue() + "]");
                for (TipoVehiculoProfesional tipo : TipoVehiculoProfesional.values()) {
                    System.out.println(tipo.getKey() + ".- " + tipo.getValue());
                }
                temp = lector.nextLine();
                if (!"".equals(temp)) {
                    tipoVehiculoPro = TipoVehiculoProfesional.getVehiculoProfesionalByKey(Integer.parseInt(temp));
                }
            }
        }

        MarcaVehiculo marca = vehiculoOriginal.getMarca();
        System.out.println("¿Cual es la marca del vehiculo? - Seleccione un número [" + marca.getKey() + ".- " + marca.getValue() + "]");
        for (MarcaVehiculo m : MarcaVehiculo.values()) {
            System.out.println(m.getKey() + ".- " + m.getValue());
        }
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            marca = MarcaVehiculo.getMarcaByKey(Integer.parseInt(temp));
        }

        String modelo = null;
        System.out.println("¿Cual es el modelo? [" + modelo + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            modelo = temp;
        }

        TipoCombustible tipoCombustible = vehiculoOriginal.getCombustible();
        System.out.println("¿Que tipo de combustible utiliza? - Seleccione un número [" + tipoCombustible.getKey() + ".- " + tipoCombustible.getValue() + "]");
        for (TipoCombustible combustible : TipoCombustible.values()) {
            System.out.println(combustible.getKey() + ".- " + combustible.getValue());
        }
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            tipoCombustible = TipoCombustible.getCombustibleByKey(Integer.parseInt(temp));
        }

        Boolean abs = vehiculoOriginal.getABS();
        System.out.println("¿Tiene ABS? - Responde Si o No [" + Utilidades.booleanToString(abs) + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            abs = temp.equalsIgnoreCase("SI");
        }

        float caballos = vehiculoOriginal.getCaballos();
        System.out.println("¿Caballos? [" + caballos + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            caballos = Float.parseFloat(temp);
        }

        float cilindrada = vehiculoOriginal.getCilindrada();
        System.out.println("¿Cilindrada? [" + cilindrada + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            cilindrada = Float.parseFloat(temp);
        }

        float almacenamiento = vehiculoOriginal.getAlmacenamiento();
        System.out.println("¿Almacenamiento [" + cilindrada + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            almacenamiento = Float.parseFloat(temp);
        }

        Boolean airbag = vehiculoOriginal.getAirbag();
        System.out.println("¿Tiene airbag? - Responde Si o No [" + Utilidades.booleanToString(airbag) + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            airbag = temp.equalsIgnoreCase("SI");
        }

        Boolean gps = vehiculoOriginal.getGPS();
        System.out.println("¿Tiene GPS integrado? - Responde Si o No [" + Utilidades.booleanToString(gps) + "]");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            gps = temp.equalsIgnoreCase("SI");
        }

        TipoMoto tipoMoto = TipoMoto.OTRO;

        Boolean descapotable = false;
        Boolean climatizado = false;
        int numPasajeros = 0;
        int numPuertas = 0;
        Boolean aireAcondicionado = false;

        if (numeroRuedas == 2) {

            System.out.println("¿De que tipo es? - Seleccione un número");
            for (TipoMoto tipo : TipoMoto.values()) {
                System.out.println(tipo.getKey() + ".- " + tipo.getValue());
            }
            tipoMoto = TipoMoto.getTipoMotoByKey(lector.nextInt());
            lector.nextLine();

        } else if (numeroRuedas == 4) {

            VehiculoCuatroRuedas vcr = vehiculoOriginal instanceof VehiculoCuatroRuedas ? (VehiculoCuatroRuedas) vehiculoOriginal : null;
            if (vcr != null) {
                descapotable = vcr.getDescapotable();
                climatizado = vcr.getClimatizado();
                numPasajeros = vcr.getNumPasajeros();
                numPuertas = vcr.getNumPuertas();
                aireAcondicionado = vcr.getAireAcondicionado();
            }

            System.out.println("¿Es descapotable? - Responde Si o No [" + Utilidades.booleanToString(descapotable) + "]");
            temp = lector.nextLine();
            if (!"".equals(temp)) {
                descapotable = temp.equalsIgnoreCase("SI");
            }

            System.out.println("¿Es climatizado? - Responde Si o No [" + Utilidades.booleanToString(climatizado) + "]");
            temp = lector.nextLine();
            if (!"".equals(temp)) {
                climatizado = temp.equalsIgnoreCase("SI");
            }

            System.out.println("¿Cuántos pasajeros entran enº su vehiculo? [" + numPasajeros + "]");
            temp = lector.nextLine();
            if (!"".equals(temp)) {
                numPasajeros = Integer.parseInt(temp);
            }

            System.out.println("¿Cuántas puertas posee su vehiculo? [" + numPuertas + "]");
            temp = lector.nextLine();
            if (!"".equals(temp)) {
                numPuertas = Integer.parseInt(temp);
            }

            System.out.println("¿Tiene aire acondicionado? - Responde Si o No [" + Utilidades.booleanToString(aireAcondicionado) + "]");
            temp = lector.nextLine();
            if (!"".equals(temp)) {
                aireAcondicionado = temp.equalsIgnoreCase("SI");
            }
        }

        Vehiculo vehiculo = FactoriaVehiculos.crear(matricula, marca, modelo, numeroRuedas, profesional, "dni",
                tipoCombustible, abs, caballos, cilindrada, almacenamiento, airbag, gps, descapotable,
                climatizado, numPasajeros, numPuertas, aireAcondicionado, tipoVehiculoPro, tipoMoto);

        gestora.guardarVehiculo(vehiculo);
        gestora.guardarEnXML();
    }

    public static void pedirDatosFichaReparación() {

        String matricula, dni;

        System.out.println("Introduce el dni del cliente:");
        dni = lector.nextLine();
        if (gestora.getCliente(dni) == null) {
            System.out.println("Nuevo cliente");
            pedirDatosUsuario(dni);
        } else {
            System.out.println("Cliente existente (" + dni + ")");
        }

        System.out.println("Introduce la matrícula:");
        matricula = lector.nextLine();
        if (gestora.getVehiculo(matricula) == null) {
            System.out.println("Nuevo vehículo");
            pedirDatosCoche(dni, matricula);
        } else {
            System.out.println("Vehículo existente (" + matricula + ")");
        }

        FichaReparacion ficha = new FichaReparacion();

        System.out.println("Motivo de la visita:");
        ficha.setComentario(lector.nextLine());

        System.out.println("¿Que tarea? - Seleccione un número");
        for (Tarea t : Tarea.values()) {
            System.out.println(t.getIdTarea() + ".- " + t.getNombre() + " (" + t.getCoste() + ")");
        }
        ficha.setTarea(Tarea.getTareaByKey(lector.nextInt()));
        lector.nextLine();

        ficha.setDniCliente(dni);
        ficha.setEstado(Estado.PENDIENTE); // Al iniciar por defecto el estado es 1 PENDIENTE
        ficha.setMatricula(matricula);
        ficha.setDniEmpleado(empleado.getDni());
        ficha.setFecha(Utilidades.getFechaActual());

        gestora.guardarFichaReparacion(ficha);
        gestora.guardarEnXML();
    }

    public static void editarFicha() {

        String temp = null;
        FichaReparacion ficha;

        int id;
        do {
            System.out.println("1.- Introduzca una matricula para modificar:");
            temp = lector.nextLine();
            if ("".equals(temp)) {
                return;
            }
            id = Integer.parseInt(temp);
        } while ((ficha = gestora.getFichaReparacion(id)) == null);

        System.out.println("Motivo de la visita [" + ficha.getComentario() + "]:");
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            ficha.setComentario(temp);
        }

        System.out.println("¿Que tarea? - Seleccione un número [" + ficha.getTarea().getIdTarea() + "]");
        for (Tarea t : Tarea.values()) {
            System.out.println(t.getIdTarea() + ".- " + t.getNombre() + " (" + t.getCoste() + ")");
        }
        temp = lector.nextLine();
        if (!"".equals(temp)) {
            ficha.setTarea(Tarea.getTareaByKey(Integer.parseInt(temp)));
        }

        System.out.println("¿Estado? - Seleccione un número [" + ficha.getEstado().getKey() + ".- " + ficha.getEstado().getValue() + "]");
        for (Estado estado : Estado.values()) {
            System.out.println(estado.getKey() + ".- " + estado.getValue());
        }
        ficha.setEstado(Estado.getEstadoByKey(lector.nextInt()));
        lector.nextLine();
    }

    public static String getDniExistente() {

        String dni;

        do {
            System.out.println("Introduce el dni del cliente:");
            dni = lector.nextLine();
        } while (gestora.getCliente(dni) == null);

        return dni;
    }

    public static void realizarBusquedas() {

        System.out.println("1.- Buscar vehiculo por matricula.");
        System.out.println("2.- Buscar vehiculo por marca.");
        System.out.println("3.- Buscar por estado ficha.");
        System.out.println("4.- Buscar por tipo de combustible.");
        System.out.println("5.- Buscar vehiculos por cliente");
        int respuesta = lector.nextInt();
        lector.nextLine();

        switch (respuesta) {
            case 1:
                String matricula;
                do {
                    System.out.println("Introduce una matricula:");
                    matricula = lector.nextLine();
                    if ("".equals(matricula)) {
                        return;
                    }
                } while (!ValidacionDatos.comprobarMatricula(matricula));
                System.out.println(gestora.getVehiculo(matricula));
                break;
            case 2:
                System.out.println("Seleccione un número...");
                for (MarcaVehiculo marca : MarcaVehiculo.values()) {
                    System.out.println(marca.getKey() + ".- " + marca.getValue());
                }
                System.out.println(gestora.listadoVehiculosPorMarca(MarcaVehiculo.getMarcaByKey(lector.nextInt())));
                break;
            case 3:
                System.out.println("Seleccione un número...");
                for (Estado estado : Estado.values()) {
                    System.out.println(estado.getKey() + ".- " + estado.getValue());
                }
                System.out.println(gestora.getFichasReparacionPorEstado(Estado.getEstadoByKey(lector.nextInt())));
                break;
            case 4:
                System.out.println("Seleccione un número...");
                for (TipoCombustible tipo : TipoCombustible.values()) {
                    System.out.println(tipo.getKey() + ".- " + tipo.getValue());
                }
                System.out.println(gestora.listadoVehiculosPorCombustible(TipoCombustible.getCombustibleByKey(lector.nextInt())));
                break;
            case 5:
                System.out.println("Introduce un dni:");
                System.out.println(gestora.listadoVehiculosCliente(lector.nextLine()));
                break;
        }

    }
}
