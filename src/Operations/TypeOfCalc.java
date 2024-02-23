package Operations;

public class TypeOfCalc {

    public static void main(String[] args) {

        System.out.println(operatorKind("2*4"));
    }


    //ENUM OperationType per riconoscere il tipo di operazione
    public static OperationKind operatorKind(String operation) {
        int i = 0;

        if (operation.indexOf("+") >= 0) {
            i++;
        }
        if (operation.indexOf("-") >= 0) {
            i++;
        }
        if (operation.indexOf("*") >= 0) {
            i++;
        }
        if (operation.indexOf("/") >= 0) {
            i++;
        }
        if (operation.indexOf("^") >= 0) {
            i++;
        }
        if (i > 1 || i < 0) {
            return null;
        }
        if (operation.indexOf("+") >= 0) {
            return OperationKind.SUM;
        }
        if (operation.indexOf("-") >= 0) {
            return OperationKind.SUBTRACTION;
        }
        if (operation.indexOf("*") >= 0) {
            return OperationKind.MULTIPLICATION;
        }
        if (operation.indexOf("/") >= 0) {
            return OperationKind.DIVISION;
        }
        if (operation.indexOf("^") >= 0) {
            return OperationKind.EXPONENT;
        }
        return null;
    }

}