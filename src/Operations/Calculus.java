package Operations;

import java.util.ArrayList;
import java.util.Objects;

public class Calculus {
    public static void main(String[] args) {
        Calculus test1 = new Calculus("10+2/5*2/2*1");
        System.out.println(test1);
        //test1.calcs.add(new Division(10, 1));
        System.out.println(test1.calcs.size());
        test1.solve();
        System.out.println(test1);
    }


    ArrayList<Calc> calcs = new ArrayList<>();
    private final String input;
    private boolean isSolvable;
    private int result;

    public void solve() {
//        ArrayList<Integer> results = new ArrayList<>(calcs.size());
        for (int i = 0; i < calcs.size(); i++) {
            if (calcs.get(i).getOperationKind() == OperationKind.DIVISION && i == 0 || calcs.get(i).getOperationKind() == OperationKind.MULTIPLICATION && i == 0) {
                int tempResult = calcs.get(i).result;
                calcs.get(i + 1).setA(tempResult);
                calcs.remove(i);
            }
            if (calcs.get(i).getOperationKind() == OperationKind.DIVISION && i > 0 && 0 < calcs.size() || calcs.get(i).getOperationKind() == OperationKind.MULTIPLICATION && i > 0 && 0 < calcs.size()) {
                int tempResult = calcs.get(i).result;
                calcs.get(i - 1).setB(tempResult);
                calcs.get(i + 1).setA(tempResult);
                calcs.remove(i);
                i--;

            }
        }
//        System.out.println(results);

    }

    public Calculus(String calc) {

        input = calc;
        isSolvable();
        if (isSolvable) {
            toCalcArray();
            //this.solve();
        }
    }

    @Override
    public String toString() {
        return calcs.toString() + " = " + result;
    }

    public String getInput() {
        return input;
    }

    public int getResult() {
        if (isSolvable) {
            return result;
        } else {
            System.out.println("Warning the original operation is not solvable, return 0.");
            return 0;
        }
    }

    public void isSolvable() {
        try {
            toValuesList(input);
            isSolvable = true;
        } catch (Exception e) {
            System.out.println("Error, looks like something went wrong. Remember that u can just operate on numbers. Result is set to 0.");
            isSolvable = false;
        }
    }

    public void toCalcArray() {
        ArrayList<Integer> values = toValuesList(input);
        ArrayList<String> operators = toOperatorsList(input);
        while (operators.size() > 0) {
            switch (operators.get(0)) {
                case "/":
                    calcs.add(new Division(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                case "*":
                    calcs.add(new Multiplication(values.get(0), values.get(1)));
                    values.remove(0);
                    operators.remove(0);
                    break;
                default:
            }

        }
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
        for (int i = 0; i < elementsString.length; i++) {
            values.add(elementsString[i]);
        }
        return values;
    }
}
