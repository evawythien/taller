package talleruned.vehiculos;

public class VehiculoCuatroRuedas extends Vehiculo {

    private Boolean descapotable;
    private Boolean climatizado;
    private int numPasajeros;
    private int numPuertas;
    private Boolean aireAcondicionado;

    public VehiculoCuatroRuedas() {
        this.setNumeroRuedas(4);
    }    
    
    public Boolean getDescapotable() {
        return descapotable;
    }

    public void setDescapotable(Boolean descapotable) {
        this.descapotable = descapotable;
    }

    public Boolean getClimatizado() {
        return climatizado;
    }

    public void setClimatizado(Boolean climatizado) {
        this.climatizado = climatizado;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public String toString() {
        return "VehiculoCuatroRuedas{" + "descapotable=" + descapotable + ", climatizado=" + climatizado + ", numPasajeros=" + numPasajeros + ", numPuertas=" + numPuertas + ", aireAcondicionado=" + aireAcondicionado + '}';
    }

}
