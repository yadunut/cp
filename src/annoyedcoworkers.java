import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


class Coworker {
    long a;
    long d;

    public Coworker(long a, long d) {
        this.a = a;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Coworker{" +
                "a=" + a +
                ", d=" + d +
                '}';
    }
}

public class annoyedcoworkers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        PriorityQueue<Coworker> pq = new PriorityQueue<>(Comparator.comparingLong(c -> c.a + c.d));

        int h = Integer.parseInt(tokens[0]);
        int c = Integer.parseInt(tokens[1]);

        for (int i = 0; i < c; i++) {
            tokens = br.readLine().split(" ");
            long a = Long.parseLong(tokens[0]);
            long d = Long.parseLong(tokens[1]);
            pq.add(new Coworker(a, d));
        }
        while (h-- > 0) {
            Coworker a = pq.poll();
            a.a += a.d;
            pq.add(a);
        }
        Coworker result = pq.peek();
        while (pq.peek() != null) {
            if (result.a < pq.peek().a) result = pq.poll();
            else pq.poll();
        }
        System.out.println(result.a);
    }
}
