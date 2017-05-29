package talleruned.usuarios;

import talleruned.Utilidades;

public class Cliente extends Usuario {

    @Override
    public String toString() {
        return "DNI:  " + dni + "\nNombre y apellidos:  " + nombre + " " + apellido + " " + apellidoDos + "\nDireccion:  " + direccion + "\nTeléfono movil:  " + tlfMovil + "\nTeléfono fijo:  " + tlfFijo + "\nFecha de nacimiento:  " + Utilidades.formatFecha(fechaNacimiento) + ".";
    }

}
