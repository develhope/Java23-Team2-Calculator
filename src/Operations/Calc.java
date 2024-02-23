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
}
