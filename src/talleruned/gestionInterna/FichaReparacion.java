package talleruned.gestionInterna;

import java.util.Calendar;
import talleruned.Utilidades;

/* Se crea una por cada visita del cliente */
public class FichaReparacion {

    private int idFicha;
    private Calendar fecha;
    private String dniCliente;
    private String dniEmpleado;
    private String matricula;
    private Estado estado;
    private String comentario;

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Indetificador: " + idFicha + "\nFecha:  " + Utilidades.formatFecha(fecha) + "\nCliente:  " + dniCliente + "\nEmpleado:  " + dniEmpleado + "\nMatricula:  " + matricula + "\nEstado=" + estado + "\nComentario:  " + comentario + "\n-----------------------";
    }

}
