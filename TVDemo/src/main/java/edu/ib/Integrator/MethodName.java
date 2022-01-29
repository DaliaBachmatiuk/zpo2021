package edu.ib.Integrator;

public enum MethodName {
    EULER ("Euler"),
    EULER_MODIFIED("Euler modified");

    public final String name;

    MethodName(String name) {
        this.name = name;
    }

    public static MethodName fromName(String name) {
        return switch (name) {
            case "Euler" -> EULER;
            case "Euler modified" -> EULER_MODIFIED;
            default -> null;
        };
    }
}
