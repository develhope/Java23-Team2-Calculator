package Operations;

public class Subtraction extends Calc {
    public static void main(String[] args) {
        int[] array = {10, 5, 3};
        int[] array1 = {1, 2, 3};
        int[] array2 = {5, 2, -6};
        Calc test = new Subtraction(1, 2);
        Calc test1 = new Subtraction(3, 2);
        Calc test2 = new Subtraction(5, -7);
        Calc testArr = new Subtraction(array);
        Calc testArr1 = new Subtraction(array1);
        Calc testArr2 = new Subtraction(array2);
        System.out.println(test);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(testArr);
        System.out.println(testArr1);
        System.out.println(testArr2);
    }

    public Subtraction(int a, int b) {
        this.a = a;
        this.b = b;
        this.operationKind = OperationKind.SUBTRACTION;
        solve();
    }

    public Subtraction(int[] array) {
        this.array = array;
        this.isArray = true;
        this.operationKind = OperationKind.SUBTRACTION;
        solve();
    }

    @Override
    public void solve() {
        if (isArray) {
            int product = array[0];
            for (int i = 1; i < array.length; i++) {
                product -= array[i];
            }
            result = product;
            return;
        }
        result = a - b;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (isArray) {
            output.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                output.append(" - " + array[i]);
            }
        } else {
            output.append(a + " - " + b);
        }
        output.append(" = " + result);
        return output.toString();
    }
}
