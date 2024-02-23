package Operations;

import java.util.ArrayList;
import java.util.Objects;

public class Calculus {
    public static void main(String[] args) {
        Calculus test1 = new Calculus("10/2/5");
        System.out.println(test1);
        //test1.calcs.add(new Division(10, 1));
        System.out.println(test1.calcs.size());
    }


    ArrayList<Calc> calcs = new ArrayList<>();
    private final String input;
    private boolean isSolvable;
    private int result;


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
