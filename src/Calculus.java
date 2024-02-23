import Operations.Calc;
import Operations.Division;

import java.util.ArrayList;

public class Calculus {
     ArrayList<Calc> calcs = new ArrayList<>();
    private final String input;
    private boolean isSolvable;
    private int result;


    public Calculus(String calc) {

        input = calc;
        isSolvable();
        toCalcArray();
        //this.solve();
    }

    @Override
    public String toString() {
        return input + " = " + result;
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


   public void toCalcArray(){
       ArrayList<Integer> values = toValuesList(input);
       ArrayList<String> operators = toOperatorsList(input);
       for (int i = 0; i>operators.size(); i++){
           switch (operators.get(i)){
               case "/":
                   calcs.add(new Division(values.get(i),values.get(i+1)));
                   values.remove(i);
                   values.remove(i);
                   operators.remove(i);
                   i--;
           }

       }
   }
  public void isSolvable(){
      try {
          toValuesList(input);
          isSolvable = true;
      } catch (Exception e) {
          System.out.println("Error, looks like something went wrong. Remember that u can just operate on numbers. Result is set to 0.");
          isSolvable = false;
      }
  }
//    public void solve() {
//
//        int result = 0;
//        for (int i = 0; i < values.size(); i++) {
//            String tempOperator = operatorKind(operators.get(i));
//
//            if (tempOperator.equals("multiplication")) {
//                result = values.get(i - 1);
//                result *= values.get(i);
//                values.set(i, result);
//                values.remove(i - 1);
//                operators.remove(i);
//                i--;
//            } else if (tempOperator.equals("division")) {
//                result = values.get(i - 1);
//                result /= values.get(i);
//                values.set(i, result);
//                values.remove(i - 1);
//                operators.remove(i);
//                i--;
//            } else if (tempOperator.equals("exponent")) {
//                result = exponent(values.get(i - 1), values.get(i));
//                values.set(i, result);
//                values.remove(i - 1);
//                operators.remove(i);
//                i--;
//            }
//        }
//        result = 0;
//        for (int i = 0; i < values.size(); i++) {
//            String tempOperator = operatorKind(operators.get(i));
//            if (tempOperator.equals("sum")) {
//                result += values.get(i);
//            } else if (tempOperator.equals("sub")) {
//                result -= values.get(i);
//            }
//        }
//        this.result = result;
//
//
//    }

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



