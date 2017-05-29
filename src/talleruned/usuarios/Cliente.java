package talleruned.usuarios;

import java.util.Calendar;

public class Cliente extends Usuario {

    @Override
    public String toString() {
        return "DNI:  " + dni + "\nNombre y apellidos:  " + nombre + " " + apellido + " " + apellidoDos + "\nDireccion:  " + direccion + "\nTeléfono movil:  " + tlfMovil + "\nTeléfono fijo:  " + tlfFijo + "\nFecha de nacimiento:  " + fechaNacimiento.get(Calendar.DAY_OF_MONTH) + "/" + fechaNacimiento.get(Calendar.MONTH) + "/" + fechaNacimiento.get(Calendar.YEAR) + ".";
    }

}
