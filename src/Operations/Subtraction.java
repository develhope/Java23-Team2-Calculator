package Operations;

public class Subtraction {

    //Metodo sottrazione a più elementi
    public static double sub(double a, double b) {
        return a - b;
    }

    //Metodo sottrazione degli elementi di un array
    public static double sub(double[] values) {
        double result = values[0];
        for (int i = 1; i < values.length; i++) {
            result -= values[i];
        }
        return result;
    }
}
