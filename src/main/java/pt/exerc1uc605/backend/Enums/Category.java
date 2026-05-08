package pt.exerc1uc605.backend.Enums;

public enum Category {
    FRONTEND("front-end"),
    BACKEND("back-end");

    private final String label;

  Category(String label) {
    this.label = label;
  }

public String getLabel() {
    return this.label;
  }

  @Override
  public String toString(){
    return this.label;
  }

}
