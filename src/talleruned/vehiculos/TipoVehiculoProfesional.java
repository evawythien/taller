package talleruned.vehiculos;

public enum TipoVehiculoProfesional {

    OTRO(0, "Otro"), AMBULANCIA(1, "Ambulancia"), BOMBEROS(2, "Bomberos"), POLICIA(2, "Policía");

    private final Integer key;
    private final String value;

    TipoVehiculoProfesional(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static TipoVehiculoProfesional getVehiculoProfesionalByKey(int key) {
        for (TipoVehiculoProfesional t : TipoVehiculoProfesional.values()) {
            if (t.getKey() == key) {
                return t;
            }
        }
        return TipoVehiculoProfesional.OTRO;
    }

}
