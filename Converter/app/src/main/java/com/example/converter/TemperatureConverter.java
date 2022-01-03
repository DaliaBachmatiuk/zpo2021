package com.example.converter;

public class TemperatureConverter {

    public double convert(double temperature, Scale baseScale, Scale finalScale) {
        if (baseScale == finalScale) return temperature;

        switch (baseScale) {
            case CELSIUS:
                switch (finalScale) {
                    case KELVIN: {
                        temperature += 273;
                        break;
                    }
                    case FAHRENHEIT: {
                        temperature = 9.0 / 5 * temperature + 32;
                        break;
                    }
                }
                break;
            case KELVIN:
                switch (finalScale) {
                    case CELSIUS: {
                        temperature -= 273;
                        break;
                    }
                    case FAHRENHEIT: {
                        temperature = 9.0 / 5 * (temperature - 273) + 32;
                        break;
                    }
                }
                break;
            case FAHRENHEIT:
                switch (finalScale) {
                    case KELVIN: {
                        temperature = 5.0 / 9 * (temperature - 32) + 273;
                        break;
                    }
                    case CELSIUS: {
                        temperature = 5.0 / 9 * (temperature - 32);
                        break;
                    }
                }
                break;
        }
        return temperature;
    }
}
