package talleruned.vehiculos;

import talleruned.Utilidades;

public class Vehiculo {

    private String matricula; // Identificador del coche
    private MarcaVehiculo marca;
    private String modelo;
    private int numeroRuedas;
    private String dni;
    private TipoCombustible combustible;
    private Boolean ABS;
    private float caballos;
    private float cilindrada;
    private float almacenamiento;
    private Boolean airbag;
    private Boolean GPS;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public MarcaVehiculo getMarca() {
        return marca;
    }

    public void setMarca(MarcaVehiculo marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroRuedas() {
        return numeroRuedas;
    }

    public void setNumeroRuedas(int numeroRuedas) {
        this.numeroRuedas = numeroRuedas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoCombustible getCombustible() {
        return combustible;
    }

    public void setCombustible(TipoCombustible combustible) {
        this.combustible = combustible;
    }

    public Boolean getABS() {
        return ABS;
    }

    public void setABS(Boolean ABS) {
        this.ABS = ABS;
    }

    public float getCaballos() {
        return caballos;
    }

    public void setCaballos(float caballos) {
        this.caballos = caballos;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(float almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public Boolean getAirbag() {
        return airbag;
    }

    public void setAirbag(Boolean airbag) {
        this.airbag = airbag;
    }

    public Boolean getGPS() {
        return GPS;
    }

    public void setGPS(Boolean GPS) {
        this.GPS = GPS;
    }

    @Override
    public String toString() {
        return "Vehiculo" + "\nMatricula:  " + matricula + "\nMarca:  " + marca + "\nModelo:  " + modelo +  "\nPropiertario:  " + dni+ "\nCombustible:  " + combustible + "\nABS:  " + Utilidades.booleanToString(ABS) + "\nCaballos:  " + caballos + "\nCilindrada:  " + cilindrada + "\nalmacenamiento:  " + almacenamiento + "\nAirbag:  " + Utilidades.booleanToString(airbag) + "\nGPS:  " + Utilidades.booleanToString(GPS) + "\n------------------------------------";
    }   
    

}
