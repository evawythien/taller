/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleruned.vehiculos;

/**
 *
 * @author Eva
 */
public enum TipoCoche {
    OTRO(0, "Otro"), TURISMO(1, "Turismo"), DEPORTIVO(2, "Deportivo"), TODOTERRENO(3, "Todoterreno"), FURGONETA(4, "Furgoneta");

    private final Integer key;
    private final String value;

    TipoCoche(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static TipoCoche getTipoCocheByKey(int key) {
        for (TipoCoche t : TipoCoche.values()) {
            if (t.getKey() == key) {
                return t;
            }
        }
        return TipoCoche.OTRO;
    }
}
