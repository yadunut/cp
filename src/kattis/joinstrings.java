
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SVertex {
    String value;
    SVertex next;
    SVertex(String value) {
        this.value = value;
    }
}

class LL {
    SVertex head;
    SVertex tail;

    public LL(String val) {
        this.head = new SVertex(val);
        this.tail = this.head;
    }
    public void add(LL l) {
        this.tail.next = l.head;
        this.tail = l.tail;
    }
    void print() {
        SVertex curr = this.head;
        StringBuilder sb = new StringBuilder();
        while(curr != null) {
            sb.append(curr.value);
            curr = curr.next;
        }
        System.out.println(sb);
    }
}

public class joinstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LL[] list = new LL[N];

        for (int i = 0; i < N; i++) {
            list[i] = new LL(br.readLine());
        }

        int a = 0;
        for (int i = 0; i < N - 1; i++) {
            String[] tokens = br.readLine().split(" ");
            a = Integer.parseInt(tokens[0]) - 1;
            int b = Integer.parseInt(tokens[1]) - 1;
            list[a].add(list[b]);
        }
        list[a].print();
    }
}
