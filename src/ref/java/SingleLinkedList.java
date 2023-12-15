package ref;

public class SingleLinkedList<T> implements ListADT<T> {
    public SingleLinkedList() {
        this.head = null;
    }

    static class Vertex<T> {
        T value;
        Vertex<T> next;

        Vertex(T value) {
            this.value = value;
            this.next = null;
        }

        Vertex(T value, Vertex<T> next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Vertex{");
            Vertex<T> curr = this;
            while (curr != null) {
                result.append(curr.value);
                result.append(" ");
                curr = curr.next;
            }
            result.append("}");
            return result.toString();
        }
    }

    private Vertex<T> head;

    @Override
    public T get(int index) {
        Vertex<T> curr = this.head;
        for (; index > 0; index--) {
            if (curr == null) return null;
            curr = curr.next;
        }
        return curr.value;
    }

    @Override
    public int search(T value) {
        Vertex<T> curr = this.head;
        int index = 0;
        while (curr != null) {
            if (curr.value == value) return index;
            curr = curr.next;
            index++;
        }
        return -1;
    }

    @Override
    public void insert(int index, T value) {
        if (this.head == null) {
            this.head = new Vertex<>(value);
            return;
        }
        if (index == 0) {
            this.head = new Vertex(value, this.head);
            return;
        }
        Vertex<T> curr = this.head;
        for (; index > 1; index--) {
            if (curr == null) throw new Error("invalid index");
            curr = curr.next;
        }
        curr.next = new Vertex<>(value, curr.next);
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public String toString() {
        return "SingleLinkedList{" + head + '}';
    }
}
