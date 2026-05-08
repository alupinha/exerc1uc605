package pt.exerc1uc605.backend.Enums;

public enum Status {
    ACTIVE("ativo"),
    INATIVO("inativo");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label; 
    }
}


