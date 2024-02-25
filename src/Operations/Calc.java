package Operations;

public abstract class Calc {
    protected int a, b, result;
    protected int[] array;
    protected boolean isArray;

    //Enum che identifica il tipo dell'operazione viene settato dalle child con costructor
    protected OperationKind operationKind;

    //Viene chiamato nel costruttore, capisce se è un array o no e risolve l'operazione e settando result
    abstract void solve();

    int getResult() {
        return result;
    }
    public void setA(int a){
        this.a =a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public OperationKind getOperationKind() {
        return operationKind;
    }
}
