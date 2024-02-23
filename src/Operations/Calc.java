package Operations;

public abstract class Calc {
    protected int a, b, result;
    protected int[] array;
    protected boolean isArray;
    // protected OperationKind operationKind;

    abstract void solve();

    int getResult() {
        return result;
    }
}
