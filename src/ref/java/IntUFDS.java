
package ref;

// referenced from Steven Halim
import java.util.ArrayList;

public class IntUFDS {
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

