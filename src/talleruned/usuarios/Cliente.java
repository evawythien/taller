package talleruned.usuarios;

public class Cliente extends Usuario {

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", apellidoDos=" + apellidoDos + ", dni=" + dni + ", direccion=" + direccion + ", tlfMovil=" + tlfMovil + ", tlfFijo=" + tlfFijo + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}
