package talleruned.vehiculos;

public enum TipoMoto {
    OTRO(0, "Otro"), CARRETERA(1, "Carretera"), CHOOPER(2, "Chooper"), CROSS(3, "Croos"), CUSTOM(4, "Custom"), DEPORTIVA(5, "Deportiva"), SCOOTER(6, "Scooter");

    private final Integer key;
    private final String value;

    TipoMoto(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static TipoMoto getVehiculoProfesionalByKey(int key) {
        for (TipoMoto t : TipoMoto.values()) {
            if (t.getKey() == key) {
                return t;
            }
        }
        return TipoMoto.OTRO;
    }
}
