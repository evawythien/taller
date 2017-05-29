package talleruned.vehiculos;

public class VehiculoProfesional extends VehiculoCuatroRuedas {

    protected TipoVehiculoProfesional tipo;

    public VehiculoProfesional(TipoVehiculoProfesional tipo) {
        this.tipo = tipo;
    }

    public TipoVehiculoProfesional getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculoProfesional tipo) {
        this.tipo = tipo;
    }  
    
}
