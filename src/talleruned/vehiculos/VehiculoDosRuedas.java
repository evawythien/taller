package talleruned.vehiculos;

public class VehiculoDosRuedas extends Vehiculo {

    private TipoMoto tipo;

    public VehiculoDosRuedas() {
        this.setNumeroRuedas(4);
    }

    public VehiculoDosRuedas(TipoMoto tipo) {
        this.tipo = tipo;
    }

    public TipoMoto getTipo() {
        return tipo;
    }

    public void setTipo(TipoMoto tipo) {
        this.tipo = tipo;
    }
}
