
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Calculus calculus = new Calculus("1+3-2");
        System.out.println(calculus);
        Calculus calculus1 = new Calculus("6/3+3*2");
        System.out.println(calculus1);
        Calculus calculus2 = new Calculus("1+2^2");
        System.out.println(calculus2);
        Calculus calculus3 = new Calculus("a*3");
        System.out.println(calculus3);
        Calculus calculus4 = new Calculus("0*1");
        System.out.println(calculus4);
    }
}