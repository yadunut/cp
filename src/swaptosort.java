import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class swaptosort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]);
        IntUFDS data = new IntUFDS(N);
        while (K-- > 0) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]) - 1, b = Integer.parseInt(tokens[1]) - 1;
            data.unionSet(a, b);
        }
        for (int i = 0; i < N / 2; i++) {
            // check if the swaps exist in the same node
//            System.out.printf("Checking %d and %d\n", i, N - i - 1);
            if (data.findSet(i) != data.findSet(N - 1 - i)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
class IntUFDS {
    ArrayList<Integer> p, rank, setSize;
    int numSets;

    public IntUFDS(int N) {
        this.p = new ArrayList<>(N);
        this.rank = new ArrayList<>(N);
        this.setSize = new ArrayList<>(N);
        this.numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i) return i;
        int ret = findSet(p.get(i));
        p.set(i, ret);
        return ret;
    }
    public boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public boolean unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--; // as 2 sets are merging
            int x = findSet(i), y = findSet(j); // roots of both sets
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y); setSize.set(y, setSize.get(x) + setSize.get(y));
                if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y)+1);
            }
        } else {
            return false;
        }
        return true;
    }
}

