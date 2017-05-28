package talleruned.usuarios;

import java.util.Calendar;

/**
 *
 * @author Eva
 */
public class Empleado extends Usuario {

    private String cargo;

    public Empleado(String cargo, String nombre, String apellido, String apellidoDos, String dni, String direccion, int tlfMovil, int tlfFijo, Calendar fechaNacimiento) {
        super(nombre, apellido, apellidoDos, dni, direccion, tlfMovil, tlfFijo, fechaNacimiento);
        this.cargo = cargo;
    }

}
