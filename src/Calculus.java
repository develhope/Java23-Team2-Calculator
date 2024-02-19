public class Calculus {
    private String calc;
    private int result;

    public Calculus(String calc) {

        this.calc = calc;
        this.solve();
    }

    @Override
    public String toString() {
        return calc + " = " + result;
    }

    public String getCalc() {
        return calc;
    }

    public int getResult() {
        return result;
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
        if (operation.indexOf("+") >= 0) {
            output = "sum";
            i++;
        }
        if (operation.indexOf("-") >= 0) {
            output = "sub";
            i++;
        }
        if (operation.indexOf("*") >= 0) {
            output = "multiplication";
            i++;
        }
        if (operation.indexOf("/") >= 0) {
            output = "division";
            i++;
        }
        if (operation.indexOf("^") >= 0) {
            output = "exponent";
            i++;
        }
        if (i == 1) {
            return output;
        } else return "Error";
    }

    public static int exponent(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    public static String isEvenOrOdd(int num) {
        if (num % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }

    }

    public static boolean isInt(String[] array) {
        boolean isInt = true;
        for (int i = 0; i < array.length; i++) {
            if (isInt) {
                try {
                    Integer.parseInt(array[i]);
                } catch (Exception e) {
                    isInt = false;
                }
            }
        }
        return isInt;
    }

    public void solve() {
        String operation = calc;
        // Rimuove gli spazi dalla stringa
        operation = operation.replaceAll(" ", "");
        String operators = operation.replaceAll("[0-9]", "");
        // Crea un array contenente i vari fattori dell'operazione e uno con gli operatori
        String[] elementsString = operation.split("[+^*/-]");
        String[] operatorsArray = new String[elementsString.length];
        for (int i = 1; i < operatorsArray.length; i++) {
            String[] temp = operators.split("");
            operatorsArray[i] = temp[i - 1];
        }
        operatorsArray[0] = "+";
        // Controlla che element[] sia int e se si lo inserisce in un array di interi.
        int[] elements = new int[elementsString.length];
//      Se non sono int stampa errore e resituisce null. altrimenti esegue le operazioni
        if (isInt(elementsString)) {
            for (int i = 0; i < elementsString.length; i++) {
                elements[i] = Integer.valueOf(elementsString[i]);
            }
            int result = 0;
            for (int i = 0; i < elements.length; i++) {
                String tempOperator = operatorKind(operatorsArray[i]);
                if (tempOperator.equals("sum")) {
                    result = sum(result, elements[i]);
                } else if (tempOperator.equals("sub")) {
                    result = sub(result, elements[i]);

                } else if (tempOperator.equals("multiplication")) {
                    result = multiplication(result, elements[i]);

                } else if (tempOperator.equals("division")) {
                    result = division(result, elements[i]);

                } else if (tempOperator.equals("exponent")) {
                    result = exponent(result, elements[i]);

                } else {
                    System.out.println("Error, looks like something went wrong. Remember that u can just operate one operation at the time on Int.");
                }
            }
            this.result = result;
        } else {
            System.out.println("Error, looks like something went wrong. Remember that u can just operate on numbers.");
        }
    }


}


