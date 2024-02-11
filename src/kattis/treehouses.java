import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class treehouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numTreehouses = Integer.parseInt(st.nextToken());
        int byFoot = Integer.parseInt(st.nextToken());
        int inPlace = Integer.parseInt(st.nextToken());

        ArrayList<Treehouse> houses = new ArrayList<>();
        UnionFind uf = new UnionFind(numTreehouses);

        for (int i = 0; i < byFoot; i++) {
            uf.unionSet(0, i);
        }

        for (int i = 0; i < numTreehouses; i++) {
            st = new StringTokenizer(br.readLine());
            houses.add(new Treehouse(Float.parseFloat(st.nextToken()), Float.parseFloat(st.nextToken())));
        }
        for (int i = 0; i < inPlace; i++) {
            st = new StringTokenizer(br.readLine());
            uf.unionSet(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }
        ArrayList<Edge> edges = new ArrayList<>();

        // build edge between every tree with distance
        for (int i = 0; i < numTreehouses; i++) {
            for (int j = 0; j < numTreehouses; j++) {
                if (i == j)
                    continue;
                edges.add(new Edge(i, j, dist(houses.get(i), houses.get(j))));
            }
        }
        edges.sort(Comparator.comparingDouble(o -> o.distance));
        double mst_cost = 0, num_taken = 0;
        for (Edge edge : edges) {
            if (uf.isSameSet(edge.from, edge.to)) continue;
            mst_cost += edge.distance;
            uf.unionSet(edge.from, edge.to);
            ++num_taken;
            if (num_taken == numTreehouses - 1) break;
        }
        System.out.println(mst_cost);

    }

    static double dist(Treehouse a, Treehouse b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static class Treehouse {
        float x;
        float y;

        public Treehouse(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Treehouse{x=" + x + ", y=" + y + " }";
        }
    }

    static class Edge {
        int from;
        int to;
        double distance;

        public Edge(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }
    }
}

class UnionFind {
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<Integer>(N);
        rank = new ArrayList<Integer>(N);
        setSize = new ArrayList<Integer>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i)
            return i;
        else {
            int ret = findSet(p.get(i));
            p.set(i, ret);
            return ret;
        }
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) {
                p.set(y, x);
                setSize.set(x, setSize.get(x) + setSize.get(y));
            } else {
                p.set(x, y);
                setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y))
                    rank.set(y, rank.get(y) + 1);
            }
        }
    }

    public int numDisjointSets() {
        return numSets;
    }

    public int sizeOfSet(int i) {
        return setSize.get(findSet(i));
    }
}
