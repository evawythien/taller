package talleruned.vehiculos;

public enum TipoCombustible {

    OTRO(0, "Otro"), DIESEL(1, "Diesel"), ELECTRICO(3, "Eléctrico"), GASOLINA(2, "Gasolina"), HIBRIDO(4, "Hibrido");

    private final Integer key;
    private final String value;

    TipoCombustible(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static TipoCombustible getCombustibleByKey(int key) {
        for (TipoCombustible t : TipoCombustible.values()) {
            if (t.getKey() == key) {
                return t;
            }
        }
        return TipoCombustible.OTRO;
    }
}
