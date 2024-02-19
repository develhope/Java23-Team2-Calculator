public class Calculus {
    private final String calc;
    private boolean isSolvable;
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
        if (isSolvable) {
            return result;
        } else {
            System.out.println("Warning the original operation is not solvable, return 0.");
            return 0;
        }
    }


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


    public static int division(int a, int b) {
        return a / b;
    }

    static int division(int[] values) {
        int product = values[0];

        for (int i = 1; i < values.length; i++) {
            product /= values[i];
        }
        return product;
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

    static int multiplication(int[] values) {
        int product = 1;

        for (int i = 0; i < values.length; i++) {
            product *= values[i];
        }
        return product;
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
        String[] temp = operators.split("");
        String[] operatorsArray = new String[elementsString.length];
        for (int i = 1; i < operatorsArray.length; i++) {
            operatorsArray[i] = temp[i];
        }
        operatorsArray[0] = "+";
        // Controlla che element[] sia int e se si lo inserisce in un array di interi.
        int[] elements = new int[elementsString.length];
//      Se non sono int stampa errore e resituisce null. altrimenti esegue le operazioni
        if (isInt(elementsString)) {
            this.isSolvable = true;
            for (int i = 0; i < elementsString.length; i++) {
                elements[i] = Integer.valueOf(elementsString[i]);
            }
            int result = 0;
            int operationCounter = 0;

            for (int i = 0; i < elements.length; i++) {
                String tempOperator = operatorKind(operatorsArray[i]);
                if (tempOperator.equals("multiplication")) {
                    result = elements[i - 1];
                    result *= elements[i];
                    elements[i - 1] = 0;
                    elements[i] = result;
                    operatorsArray[i] = "+";
                } else if (tempOperator.equals("division")) {
                    result = elements[i - 1];
                    result /= elements[i];
                    elements[i - 1] = 0;
                    elements[i] = result;
                    operatorsArray[i] = "+";
                } else if (tempOperator.equals("exponent")) {
                    result = elements[i - 1];
                    result = exponent(elements[i - 1], elements[i]);
                    elements[i - 1] = 0;
                    elements[i] = result;
                    operatorsArray[i] = "+";

                }
            }
            result = 0;
            for (int i = 0; i < elements.length - 1; i++) {
                String tempOperator = operatorKind(operatorsArray[i]);
                if (tempOperator.equals("sum")) {
                    result += elements[i + 1];
                } else if (tempOperator.equals("sub")) {
                    result -= elements[i + 1];
                } else {
                    isSolvable = false;
                    System.out.println("Error, looks like something went wrong and you cannot get the kind of operation");
                }
            }
            this.result = result;
        } else {
            System.out.println("Error, looks like something went wrong. Remember that u can just operate on numbers. Result is set to 0.");
        }
    }


}


