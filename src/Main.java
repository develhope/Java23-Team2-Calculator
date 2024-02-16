public class Main {
    public static void main(String[] args) {
      
        static int num = 25;
        static String result = isEvenOrOdd(num);
        System.out.println(division(12, 3));
        System.out.println(sub(10, 3));
        System.out.println(sum(2, 4));
        System.out.println(multiplication(2, 10));
        System.out.println(calculator("1*a"));
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

    public static Integer calculator(String operation) {
        // Rimuove gli spazi dalla stringa
        operation = operation.replace(" ", "");
        // Crea un array contenente i vari fattori dell'operazione
        String[] elementsString = operation.split("[+-/^*]");
        // Controlla che element[] sia int e se si lo immagizina in un array di interi.
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

        if (elementsAreNotInt) {
            System.out.print("Error, looks like something went wrong. Remember that u can just operate one operation at the time. Return: ");
            return null;
        } else {
            switch (operatorKind(operation)) {
                case "sum":
                    return sum(elements);
                case "sub":
                    return sub(elements[0], elements[1]);
                case "multiplication":
                    return multiplication(elements[0], elements[1]);
                case "division":
                    return division(elements[0], elements[1]);
                case "error":
                    System.out.println("Error, looks like something went wrong. Remember that u can just operate one operation at the time on Int.");
                    break;
            }
        }
        return null;
    }

    public static String isEvenOrOdd(int num) {
        if (num % 2 == 0) {
            return "even";
          } else {
            return "odd";
        }

      }
}

