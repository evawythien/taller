package talleruned.vehiculos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Eva
 */
public enum MarcaVehiculo {

    OTRAS(0,"Otras"), AUDI(1, "Audi"), VOLKSWAGEN(2, "Volkseagen"), BMV(3, "Bmv"), SKODA(4, "Skoda"), FIAT(5, "Fiat"), FORD(6, "Ford"), TOYOTA(7, "Toyota"), SUZUKI(8, "Suzuki");

    private final Integer key;
    private final String value;

    private MarcaVehiculo(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    
    public static MarcaVehiculo getMarcaByKey(int key) {
        for (MarcaVehiculo m : MarcaVehiculo.values()){
            if(m.getKey() == key){
                return m;
            }
        }
        return MarcaVehiculo.OTRAS;
    }

}
