public class Main {

    public static void main(String[] args) {

        System.out.println(calculator("10/6"));
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
            output = "exponents";
            i++;
        }
        if (i == 1) {
            return output;
        } else return "Error";
    }

    public static Integer calculator(String operation) {
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
        boolean elementsAreNotInt = false;
        int[] elements = new int[elementsString.length];
        for (int i = 0; i < elementsString.length; i++) {
            try {
                Integer.parseInt(elementsString[i]);
                elements[i] = Integer.valueOf(elementsString[i]);
            } catch (Exception e) {
                elementsAreNotInt = true;
            }
        }
//      Se non sono int stampa errore e resituisce null. altrimenti esegue le operazioni
        if (elementsAreNotInt) {
            System.out.print("Error, looks like something went wrong. Remember that u can just operate on numbers. Return: ");
            return null;
        } else {
            int result = 0;
            for (int i = 0; i < elements.length; i++) {
                String tempOperator = operatorKind(operatorsArray[i]);
                if (tempOperator.equals("sum")) {
                    result = sum(result, elements[i]);
                } else if (tempOperator.equals("sub")) {
                    result = sub(elements[i], elements[i]);

                } else if (tempOperator.equals("multiplication")) {
                    result = multiplication(result, elements[i]);

                } else if (tempOperator.equals("division")) {
                    result = division(result, elements[i]);

                } else {
                    System.out.println("Error, looks like something went wrong. Remember that u can just operate one operation at the time on Int.");
                    return null;
                }
            }
            return result;
        }
    }

}




