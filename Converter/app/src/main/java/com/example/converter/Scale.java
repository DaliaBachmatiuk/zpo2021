package com.example.converter;

public enum Scale {
    CELSIUS (0),
    KELVIN (1),
    FAHRENHEIT (2);

    private final int position;

    Scale(int position) {
        this.position = position;
    }

    public static Scale fromPosition(int position) {
        if (position == 0) return CELSIUS;
        if (position == 1) return KELVIN;
        return FAHRENHEIT;
    }
}
