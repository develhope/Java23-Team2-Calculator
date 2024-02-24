package Operations;

public class Subtraction extends Calc {
    public static void main(String[] args) {

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
