package Operations;

public class Multiplication extends Calc{
   //TEST per la moltiplicazione
    public static void main(String[] args) {
        Calc test1 = new Multiplication(41, 212);
        System.out.println(test1);
        Calc test2 = new Multiplication(42410, 414);
        System.out.println(test2);
        int[] testArray = new int[]{210, 261, 775};
        Calc test3 = new Multiplication(testArray);
        System.out.println(test3);
        int[] testArray2 = new int[]{-110, 2, 6};
        Calc test4 = new Multiplication(testArray2);
        System.out.println(test4);
    }

    public Multiplication(int a, int b) {
        this.a = a;
        this.b = b;
        solve();
    }

    public Multiplication(int[] array) {
        this.array = array;
        this.isArray = true;
        solve();
    }

    //controlla se l'istanza corrente è un array
    @Override
    public void solve() {
        if (isArray) {
            int product = array[0];
            for (int i = 1; i < array.length; i++) {
                product *= array[i];
            }
            result = product;
            return;
        }
        result = a * b;
    }

    //genera una rappresentazione testuale dell'operazione
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (isArray) {
            output.append(array[0]);
            for (int i = 1; i < array.length; i++) {
                output.append(" * " + array[i]);
            }
        } else {
            output.append(a + " * " + b);
        }
        output.append(" = " + result);
        return output.toString();
    }
}
