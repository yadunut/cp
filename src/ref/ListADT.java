package ref;

public interface ListADT<T> {
    T get(int index);

    int search(T value);

    void insert(int index, T value);

    T remove(int index);
}
