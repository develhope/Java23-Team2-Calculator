import Operations.Exponents;

import java.util.ArrayList;

public class OldCalculus {
    private final String calc;
    private boolean isSolvable;
    private int result;

    public OldCalculus(String calc) {

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



    public static String isEvenOrOdd(int num) {
        if (num % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }

    }


    public void solve() {
        ArrayList<Integer> values;
        try {
            values = toValuesList(calc);
            isSolvable = true;
        } catch (Exception e) {
            System.out.println("Error, looks like something went wrong. Remember that u can just operate on numbers. Result is set to 0.");
            isSolvable = false;
            return;
        }
        ArrayList<String> operators = toOperatorsList(calc);
        int result = 0;
        for (int i = 0; i < values.size(); i++) {
            String tempOperator = operatorKind(operators.get(i));

            if (tempOperator.equals("multiplication")) {
                result = values.get(i - 1);
                result *= values.get(i);
                values.set(i, result);
                values.remove(i - 1);
                operators.remove(i);
                i--;
            } else if (tempOperator.equals("division")) {
                result = values.get(i - 1);
                result /= values.get(i);
                values.set(i, result);
                values.remove(i - 1);
                operators.remove(i);
                i--;
            } else if (tempOperator.equals("exponent")) {
                result = Exponents.exponent(values.get(i - 1), values.get(i));
                values.set(i, result);
                values.remove(i - 1);
                operators.remove(i);
                i--;
            }
        }
        result = 0;
        for (int i = 0; i < values.size(); i++) {
            String tempOperator = operatorKind(operators.get(i));
            if (tempOperator.equals("sum")) {
                result += values.get(i);
            } else if (tempOperator.equals("sub")) {
                result -= values.get(i);
            }
        }
        this.result = result;


    }

    private static ArrayList<Integer> toValuesList(String calc) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        calc = calc.replaceAll(" ", "");
        String[] elementsString = calc.split("[+^*/-]");
        for (int i = 0; i < elementsString.length; i++) {
            values.add(Integer.valueOf(elementsString[i]));
        }
        return values;
    }

    private static ArrayList<String> toOperatorsList(String calc) {
        ArrayList<String> values = new ArrayList<String>();
        calc = calc.replaceAll(" ", "");
        calc = calc.replaceAll("[0-9]", "");
        String[] elementsString = calc.split("");
        values.add("+");
        for (int i = 0; i < elementsString.length; i++) {
            values.add(elementsString[i]);
        }
        return values;
    }


}



