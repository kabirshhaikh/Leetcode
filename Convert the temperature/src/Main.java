import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        double celsius = 36.50;
        double[] test = convertTemperature(celsius);
        System.out.println(Arrays.toString(test));
    }


    public static double[] convertTemperature (double celsius) {
        double kelvin = 0.0;
        double fahrenheit = 0.0;

        double[] output = new double[2];

        kelvin = celsius + 273.15;
        fahrenheit = celsius * 1.80 + 32.00;

        output[0] = kelvin;
        output[1] = fahrenheit;

        return output;
    }
}

