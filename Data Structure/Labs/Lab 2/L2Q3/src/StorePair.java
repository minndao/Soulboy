

public class StorePair<T extends Comparable<T>> implements Comparable<StorePair<T>> {
    private T first, second;

    public StorePair (T first, T second) {
this.first = first;
this.second = second;
}

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first + " second = " + second;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof StorePair)) {
            return false;
        }
        StorePair<?> other = (StorePair<?>) object;

        return java.util.Objects.equals(this.first, other.first);
        }

    @Override
    public int compareTo(StorePair<T> object) {
        return this.first.compareTo(object.first);
    }

    



}
