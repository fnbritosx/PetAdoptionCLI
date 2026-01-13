package model.entity;

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

    public static PetSex fromFormatted(String value) {
        for (PetSex sex : values()) {
            if (sex.formatted.equalsIgnoreCase(value)) {
                return sex;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + value);
    }

}

