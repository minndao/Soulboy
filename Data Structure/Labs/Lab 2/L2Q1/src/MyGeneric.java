public class MyGeneric<T> {
    private T e;


    MyGeneric(T e) {
        this.e = e;
    }

    public T getType() {
        return e;
    }

    public void setType(T e) {
        this.e = e;
    }
}