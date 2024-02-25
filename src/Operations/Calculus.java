package Operations;

import java.util.ArrayList;
import java.util.Objects;

public class Calculus {
    public static void main(String[] args) {
        System.out.println(new Calculus("3*2"));
        System.out.println(new Calculus("6/2"));
        System.out.println(new Calculus("3^2"));
        System.out.println(new Calculus("22-9"));
        System.out.println(new Calculus("22-6/2"));
        System.out.println(new Calculus("22-3*2"));
        System.out.println(new Calculus("22-3^2"));
        System.out.println(new Calculus("6/2-3^2"));
        System.out.println(new Calculus("3*2-3"));
        System.out.println(new Calculus("3^2-9"));
        System.out.println(new Calculus("a2*2"));
        System.out.println(new Calculus("22"));
    }


    private final String input;
    private static boolean isSolvable;
    private int result;

    private void solve() {
        ArrayList<Calc> calcs = new ArrayList<>();
        toCalcArray(input, calcs);
        for (int i = 0; i < calcs.size(); ) {
            if (calcs.get(i).operationKind.equals(OperationKind.SUM) || calcs.get(i).operationKind.equals(OperationKind.SUBTRACTION)) {
                i++;
            } else if (calcs.get(i).operationKind.equals(OperationKind.DIVISION) || calcs.get(i).operationKind.equals(OperationKind.MULTIPLICATION) || calcs.get(i).operationKind.equals(OperationKind.EXPONENT)) {
                if (calcs.size() == 1) {
                    result = calcs.get(i).result;
                    return;
                }
                if (i > 0) {
                    calcs.get(i - 1).setB(calcs.get(i).result);
                }
                if (i < calcs.size() - 1) {
                    calcs.get(i + 1).setA(calcs.get(i).result);
                }
                calcs.remove(i);
            }


        }
        for (int i = 0; i < calcs.size(); ) {
            if (calcs.get(i).operationKind.equals(OperationKind.SUM) || calcs.get(i).operationKind.equals(OperationKind.SUBTRACTION)) {
                result += calcs.get(i).result;
                i++;
            }
        }

    }

    public Calculus(String calc) {
        input = calc;
        solve();
    }

    @Override
    public String toString() {
        return input + " = " + result;
    }

    public int getResult() {
        if (isSolvable) {
            return result;
        } else {
            System.out.println("Warning the original operation is not solvable, return 0.");
            return 0;
        }
    }

    public void toCalcArray(String input, ArrayList<Calc> array) {
        ArrayList<Integer> values = toValuesList(input);
        if (values == null) {
            System.out.println("Error, looks like u are tryng to do a not possible operation: ");
            isSolvable = false;
            result = 0;
            return;
        }

        if (values.size() == 1) {
            System.out.println("Error, looks like u are not tryng to do any operation.");
            isSolvable = false;
            result = values.get(0);
            return;
        }
        ArrayList<String> operators = toOperatorsList(input);
        while (operators.size() > 0) {
            switch (operators.get(0)) {
                case "/":
                    array.add(new Division(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                case "*":
                    array.add(new Multiplication(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                case "-":
                    array.add(new Subtraction(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                case "^":
                    array.add(new Exponents(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                case "+":
                    System.out.println("Not implemented operation yet");
                   // array.add(new Sum(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                default:
                    break;
            }

        }
    }

    private static ArrayList<Integer> toValuesList(String calc) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        calc = calc.replaceAll(" ", "");
        String[] elementsString = calc.split("[+^*/-]");
        for (int i = 0; i < elementsString.length; i++) {
            try {
                values.add(Integer.valueOf(elementsString[i]));
            } catch (Exception e) {
                isSolvable = false;
                return null;
            }
        }
        return values;
    }


    private static ArrayList<String> toOperatorsList(String calc) {
        ArrayList<String> values = new ArrayList<String>();
        calc = calc.replaceAll(" ", "");
        calc = calc.replaceAll("[0-9]", "");
        String[] elementsString = calc.split("");
        for (int i = 0; i < elementsString.length; i++) {
            values.add(elementsString[i]);
        }
        return values;
    }
}
