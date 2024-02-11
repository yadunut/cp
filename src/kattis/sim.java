import java.util.Scanner;

class DLL<T> {
    static class Vertex<T> {
        public Vertex(T value, Vertex<T> previous, Vertex<T> next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        T value;
        Vertex<T> next;
        Vertex<T> previous;

    }

    Vertex<T> head;
    Vertex<T> tail;
    Vertex<T> current;

    public DLL() {
    }

    void add(T val) {
        Vertex<T> v = new Vertex<>(val, null, null);
        // current is the starting item (home / empty)
        if (current == null) {
            v.next = this.head;
            if (this.head != null) this.head.previous = v;
            this.head = v;
            this.current = v;
            if (this.tail == null) this.tail = v;
            return;
        }
        // if its the tail node
        if (current == this.tail) {
            v.previous = current;
            current.next = v;
            this.tail = v;
            this.current = v;
            return;
        }
        // if inbetween
        v.previous = current;
        v.next = current.next;
        current.next = v;
        this.current = v;
    }

    void backspace() {
        if (this.current == null) return;
        if (this.current == this.head) this.head = this.current.next;
        if (this.current == this.tail) this.tail = this.current.previous;
        if (current.next != null) current.next.previous = current.previous;
        if (current.previous != null) current.previous.next = current.next;
        this.current = this.current.previous;

    }

    void home() {
        this.current = null;
    }

    void end() {
        this.current = this.tail;
    }

    @Override
    public String toString() {
        Vertex<T> curr = this.head;
        if (curr == null) return "";
        StringBuilder sb = new StringBuilder();
        while (curr != this.tail) {
            sb.append(curr.value);
            curr = curr.next;
        }
        sb.append(curr.value);
        return sb.toString();
    }
}

public class sim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (; T > 0; T--) {
            DLL<Character> ll = new DLL<>();
            char[] line = sc.nextLine().toCharArray();
            for (char c : line) {
                // if it is not special character, add char to current index;
                switch (c) {
                    case '<': {
                        ll.backspace();
                        break;
                    }
                    case ']':
                        ll.end();
                        break;
                    case '[':
                        ll.home();
                        break;
                    default:
                        ll.add(c);
                        break;
                }
            }
            System.out.println(ll);
        }

    }
}
