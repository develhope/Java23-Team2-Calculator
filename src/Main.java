public class Main {

    static int num = 25;
    static String result = isEvenOrOdd(num);

    public static void main(String[] args) {
        System.out.println(division(12, 3));
        System.out.println(sub(10, 3));
        System.out.println(sum(2, 4));
        System.out.println(multiplication(2, 10));
        //la prossima riga stampa il check pari dispari
        System.out.println(num + " is " + result);


    }


    public static int sub(int a, int b) {
        return a - b;

    }

    public static int division(int a, int b) {
        return a / b;
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

    public static String isEvenOrOdd(int num) {
        if (num % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }

        }
}

