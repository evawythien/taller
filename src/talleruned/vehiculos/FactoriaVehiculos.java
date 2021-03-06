package talleruned.vehiculos;

/**
 * Una factoría sirve para esconder la implementación y construcción de objetos
 * de una factoría de clases determinada
 */
public class FactoriaVehiculos {

    public static Vehiculo crear(String matricula, MarcaVehiculo marca, String modelo, int numeroRuedas, Boolean profesional, String dni, TipoCombustible combustible, Boolean ABS, float caballos,
            float cilindrada, float almacenamiento, Boolean airbag, Boolean GPS, Boolean descapotable, Boolean climatizado, int numPasajeros, int numPuertas, Boolean aireAcondicionado,
            TipoVehiculoProfesional tipoProfesional, TipoMoto tipoMoto) {

        Vehiculo v = null;

        if (numeroRuedas == 4) {

            VehiculoCuatroRuedas vTemp = null;

            if (profesional) {
                vTemp = new VehiculoProfesional(tipoProfesional);
            } else {
                vTemp = new VehiculoCuatroRuedas();
            }

            // Variables comunes a las 4 ruedas
            vTemp.setDescapotable(descapotable);
            vTemp.setClimatizado(climatizado);
            vTemp.setNumPasajeros(numPasajeros);
            vTemp.setNumPuertas(numPuertas);
            vTemp.setClimatizado(climatizado);
            vTemp.setAireAcondicionado(aireAcondicionado);

            v = vTemp;

        } else if (numeroRuedas == 2) {
            v = new VehiculoDosRuedas(tipoMoto);
        }

        // Si no se ha instanciado vehículo, es por que no está soportado.
        // Variables comunes a todos los Vehiculos
        if (v != null) {
            v.setMatricula(matricula);
            v.setMarca(marca);
            v.setModelo(modelo);
            v.setNumeroRuedas(numeroRuedas);
            v.setDni(dni);
            v.setCombustible(combustible);
            v.setABS(ABS);
            v.setCaballos(caballos);
            v.setCilindrada(cilindrada);
            v.setAlmacenamiento(almacenamiento);
            v.setAirbag(airbag);
            v.setGPS(GPS);
        }

        return v;
    }
}
