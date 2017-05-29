package talleruned.gestionInterna;

public enum Estado {

    PENDIENTE(1, "Pendiente"), EN_PROCESO(2, "En proceso"), PARADO(3, "Parado"), FASE_DE_PRUEBA(4, "Fase de prueba"), TERMINADO(5, "Terminado");

    private final Integer key;
    private final String value;

    Estado(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
