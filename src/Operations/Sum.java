package Operations;

import java.util.Arrays;

public class Sum extends Calc {
    public static void main(String[] args) {
        Sum test1 = new Sum(20, 10);
        int[] arrayTest = {10, 3, 4};
        Sum test2 = new Sum(arrayTest);
        System.out.println(test1);
        System.out.println(test2);
    }

    public Sum(int a, int b) {
        this.a = a;
        this.b = b;
        this.isArray = false;
        this.operationKind = OperationKind.SUM;
        solve();
    }

    @Override
    void solve() {
        if (isArray) {
            result = 0;
            for (int i = 0; i < array.length; i++) {
                result += array[i];
            }
            return;
        }
        result = a + b;

    }

    public Sum(int[] array) {
        this.array = array;
        this.isArray = true;
        this.operationKind = OperationKind.SUM;
        solve();
    }

    @Override
    public String toString() {
        if (isArray) {
            return Arrays.toString(array) + " = " + result;
        }
        return a + " + " + b + " = " + result;

    }
}
