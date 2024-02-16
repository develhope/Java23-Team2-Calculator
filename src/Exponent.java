public class Exponent {

    /*L'oggetto "exponent" ha in commento due Override to String(),
    così che possiamo decidere, in base a cosa vogliamo dal programma, cosa mandare in stampa.
    Nel primo vengono mandati in stampa gli elementi e i loro valori, nel secondo viene mandata
    l'equazione, nel terzo (non in commento) viene mandata l'equazione ed il risultato insieme.*/

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

//    @Override  //manda in stampa i dati e i loro valori (base= a, exp= b)
//    public String toString() {
//        return "Exponent{" +
//                "base=" + base +
//                ", exp=" + exp +
//                '}';
//    }

//    @Override  // manda in stampa l'equazione (a^b)
//    public String toString() {
//        return base +
//                " ^ " + exp;
//    }

        @Override //manda in stampa equazione e risultato (a^b=x)
    public String toString() {
        return base +
                " ^ " + exp +
                " = " + getResult();
    }
}
