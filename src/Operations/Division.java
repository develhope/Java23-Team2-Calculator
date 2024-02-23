package Operations;

import java.util.Arrays;

public class Division extends Calc {

    public static void main(String[] args) {
        Calc test1 = new Division(10, 2);
        System.out.println(test1);
        Calc test2 = new Division(20, 5);
        System.out.println(test2);
        int[] testArray = new int[]{20, 2, 5};
        Calc test3 = new Division(testArray);
        System.out.println(test3);
        int[] testArray2 = new int[]{-100, 2, 5};
        Calc test4 = new Division(testArray2);
        System.out.println(test4);
    }

    public Division(int a, int b) {
        this.a = a;
        this.b = b;
        this.operationKind = OperationKind.DIVISION;
        solve();
    }

    public Division(int[] array) {
        this.array = array;
        this.isArray = true;
        this.operationKind = OperationKind.DIVISION;
        solve();
    }

    @Override
    public void solve() {
        if (isArray) {
            int product = array[0];
            for (int i = 1; i < array.length; i++) {
                product /= array[i];
            }
            result = product;
            return;
        }
        result = a / b;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (isArray) {
            output.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                output.append(" / " + array[i]);
            }
        } else {
            output.append(a + " / " + b);
        }
        output.append(" = " + result);
        return output.toString();
    }
}
