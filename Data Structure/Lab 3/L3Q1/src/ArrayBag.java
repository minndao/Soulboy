public class ArrayBag<T> implements BagInterface<T> {
    private T[] bag;
    private final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isFull() {
        return numberOfEntries >= DEFAULT_CAPACITY;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        numberOfEntries++;
        if  (numberOfEntries > DEFAULT_CAPACITY) {
            return false;
        } else {
            bag[numberOfEntries] = newEntry;
            return true;
        }
    }

    @Override
    public T remove() {
        T removed;
        removed = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return removed;
    }

    public boolean remove (T anEntry) {
        if (isEmpty()) {
            return false;
        }
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                bag[i] = null;
                numberOfEntries--;
                return true;
            }
        }

        return false;
    }

    public void clear() {
        numberOfEntries = 0;
        bag = null;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                frequency++;
            }
        }
        return frequency;
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] newBag = (T[]) new Object [numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            newBag[i] = bag[i];
        }

        return newBag;
    }
}