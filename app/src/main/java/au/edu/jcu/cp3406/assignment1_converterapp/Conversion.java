package au.edu.jcu.cp3406.assignment1_converterapp;

public class Conversion {
    //convert to fahrenheit
    public static double toFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }

    //convert to celsius
    public static double toCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
