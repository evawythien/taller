package talleruned.usuarios;

import java.util.Calendar;
import java.util.Date;

public class Usuario {

    /* Son protected para permitir a las subclases acceder a los campos  */
    protected String nombre;
    protected String apellido;
    protected String apellidoDos;
    protected String dni;
    protected String direccion;
    protected int tlfMovil;
    protected int tlfFijo;
    protected Calendar fechaNacimiento;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String apellidoDos, String dni, String direccion, int tlfMovil, int tlfFijo, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apellidoDos = apellidoDos;
        this.dni = dni;
        this.direccion = direccion;
        this.tlfMovil = tlfMovil;
        this.tlfFijo = tlfFijo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTlfMovil() {
        return tlfMovil;
    }

    public void setTlfMovil(int tlfMovil) {
        this.tlfMovil = tlfMovil;
    }

    public int getTlfFijo() {
        return tlfFijo;
    }

    public void setTlfFijo(int tlfFijo) {
        this.tlfFijo = tlfFijo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
