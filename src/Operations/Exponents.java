package Operations;

public class Exponents extends Calc {
    public static void main(String[] args) {
        Calc test= new Exponents(2,3);
        Calc test1= new Exponents(2,-3);
        Calc test2= new Exponents(2,-2);
        Calc test3= new Exponents(-2,3);
        Calc test4= new Exponents(-2,-3);
        Calc test5= new Exponents(-2,-2);
        Calc test6= new Exponents(-2,0);
        System.out.println(test);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        System.out.println(test4);
        System.out.println(test5);
        System.out.println(test6);
    }
    public Exponents(int a, int b) {
        this.a = a;
        this.b = b;
        this.operationKind = OperationKind.EXPONENT;
        solve();
    }

    public static int exponent(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    @Override
    public void solve() {
        result = exponent(a,b);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(a + " ^ " + b);

        output.append(" = " + result);
        return output.toString();
    }


}
