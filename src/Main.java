public class Main {

    public static void main(String[] args) {

        System.out.println(sum(2, 4));
        System.out.println(multiplication(2, 10));
    }


    public static int sum(int a, int b) {
        return a + b;

    }

    public static int sum(int[] values) {
        int results = 0;
        for (int i = 0; i < values.length; i++) {
            results += values[i];
        }
        return results;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static String operatorKind(String operation) {
        String output = "";
        int i = 0;
        if (operation.indexOf("+") > 0) {
            output = "sum";
            i++;
        }
        if (operation.indexOf("-") > 0) {
            output = "sub";
            i++;
        }
        if (operation.indexOf("*") > 0) {
            output = "multiplication";
            i++;
        }
        if (operation.indexOf("/") > 0) {
            output = "division";
            i++;
        }
        if (operation.indexOf("^") > 0) {
            output = "exponents";
            i++;
        }
        if (i == 1) {
            return output;
        } else return "Error";
    }

}
