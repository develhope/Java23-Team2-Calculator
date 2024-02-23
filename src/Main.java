import Operations.Subtraction;

public class Main {
    public static void main(String[] args) {
        //Array di prova
        double[] numbers = {50, 20, 3};
        double[] otherNumbers = {5, 7, 2};
        double[] negatives = {-5, -3, -10};
        //Stampa sottrazioni a due elementi.
        System.out.println("Stampa sottrazioni a due elementi.");
        System.out.println(Subtraction.sub(2, 3));
        System.out.println(Subtraction.sub(5, 3));
        System.out.println(Subtraction.sub(-5, 3));
        System.out.println();
        //Stampa sottrazioni tra elementi di arrays
        System.out.println("Stampa sottrazioni tra elementi di arrays");
        System.out.println(Subtraction.sub(numbers));
        System.out.println(Subtraction.sub(otherNumbers));
        System.out.println(Subtraction.sub(negatives));
        System.out.println();


        Calculus calculus2 = new Calculus("1+3*2/3^2");
        System.out.println(calculus2);
    }
}