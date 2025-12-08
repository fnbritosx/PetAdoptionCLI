package src.model.entity;

public enum PetSex {
    MACHO("Macho"),
    FEMEA("Femea");

    private final String formatted;

    PetSex(String formatted) {
        this.formatted = formatted;
    }

    public String getFormatted() {
        return formatted;
    }
}

