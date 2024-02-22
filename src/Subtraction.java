
public class Subtraction {
    public static int sub(int a, int b) {
        return a - b;
    }

    static int sub(int[] values) {
        int result = values[0];
        for (int i = 1; i < values.length; i++) {
            result -= values[i];
        }
        return result;
    }
}
