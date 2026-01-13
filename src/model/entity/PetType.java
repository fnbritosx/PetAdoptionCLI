package model.entity;

public enum PetType {
    CACHORRO("Cachorro"),
    GATO("Gato");

    private final String formatted;

    PetType(String formatted) {
        this.formatted = formatted;
    }

    public String getFormatted() {
        return formatted;
    }

    public static PetType fromFormatted(String value) {
        for (PetType type : values()) {
            if (type.formatted.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + value);
    }

}
