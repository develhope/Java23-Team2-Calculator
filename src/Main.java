
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Calculus calculus = new Calculus("2+3^3");
        System.out.println();
        System.out.println(calculus.getCalc());
        System.out.println(calculus.getResult());

    }
  public static ArrayList<Integer> multipleDivision(int dividend, int[] divisors) {
        ArrayList<Integer> quotients = new ArrayList<>();

        // Per ogni divisore
        for (int divisor : divisors) {
            // Esegue la divisione
            int quotient = dividend / divisor;
            quotients.add(quotient);
            // Aggiorna il dividendo con il resto della divisione precedente
            dividend = dividend % divisor;
        }

        return quotients;
    }

    public static void main(String[] args) {
        int dividend = 100;
        int[] divisors = {2, 5, 10};

        ArrayList<Integer> results = multipleDivision(dividend, divisors);

        System.out.println("Risultati della divisione multipla:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Divisore: " + divisors[i] + ", Quoziente: " + results.get(i));
        }
    }
}