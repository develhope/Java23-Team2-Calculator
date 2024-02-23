package Operations;

public class Subtraction {

    //Metodo sottrazione a più elementi
    public static int sub(int a, int b) {
        return a - b;
    }

    //Metodo sottrazione degli elementi di un array
    public static int sub(int[] values) {
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result -= values[i];
        }
        return result;
    }
}
