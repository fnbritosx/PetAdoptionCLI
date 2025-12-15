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
}
