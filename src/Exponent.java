public class Exponent {
    private double base;
    private double exp;

    public Exponent(double base, double exp) {
        this.base = base;
        this.exp = exp;
    }

    public double getResult() {
        double result = 1;
        double temp = this.exp;
        for (; temp != 0; --temp) {
            result *= this.base;
        }
        return result;
    }

//    @Override
//    public String toString() {
//        return "Exponent{" +
//                "base=" + base +
//                ", exp=" + exp +
//                '}';
//    }

//    @Override
//    public String toString() {
//        return base +
//                " ^ " + exp +
//                " = ";
//    }

        @Override
    public String toString() {
        return base +
                " ^ " + exp +
                " = " + getResult();
    }
}
