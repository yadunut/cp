import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class fendofftitan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numVertices = Integer.parseInt(st.nextToken());
        int numEdges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<ArrayList<Edge>> AL = new ArrayList<>();
        for (int i = 0; i < numVertices; i++)
            AL.add(new ArrayList<>());
        // build an Adjacency List, which keeps track of the <From Village, To Village, The distance, Enemy Type>
        for (int i = 0; i < numEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            long len = Long.parseLong(st.nextToken());
            int enemy = Integer.parseInt(st.nextToken());
            AL.get(from).add(new Edge(to, len, enemy));
            AL.get(to).add(new Edge(from, len, enemy)); // if bidirectional
        }

        // distance from vertex. Build it to be of max value first, which is max length and enemies.
        // The dist[u] keeps track of the total length/enemies met from start to this node.
        ArrayList<Distance> dist = new ArrayList<>();
        for (int i = 0; i < numVertices; i++)
            dist.add(Distance.Max());
        // sets the start node to 0 value
        dist.set(start, new Distance(0, 0, 0));

        // the main queue. This will store a pair of the current index, and the distance. It is sorted based on the distance
        // I have a suspicion that the error has something to do with this
        TreeSet<Pair> pq = new TreeSet<>();
        for (int i = 0; i < numVertices; i++)
            pq.add(new Pair(dist.get(i), i));

        // the standard Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair top = pq.pollFirst();
            int u = top.vertex;
            for (Edge v : AL.get(u)) {
                if (dist.get(u).add(v).compareTo(dist.get(v.toVertex)) >= 0)
                    continue;
                pq.remove(new Pair(dist.get(v.toVertex), v.toVertex));
                dist.set(v.toVertex, dist.get(u).add(v));
                pq.add(new Pair(dist.get(v.toVertex), v.toVertex));
            }
        }

        Distance result = dist.get(end);
        // pretty sure I only need to check 1 but meh
        if (result.totalLen == Long.MAX_VALUE ||
        result.numTitans == Long.MAX_VALUE ||
        result.numShamans == Long.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.printf("%d %d %d", result.totalLen, result.numShamans, result.numTitans);
        pr.close();

    }

    static class Pair implements Comparable<Pair> {
        Distance d;
        int vertex;

        public Pair(Distance d, int vertex) {
            this.d = d;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Pair o) {
            // if vertex is same then return 0.
            if (this.vertex == o.vertex)
                return 0;
            // vertex is different and thus, you cannot return 0 anymore.
            int res = this.d.compareTo(o.d);
            if (res == 0)
                return -1;
            return res;
        }
    }

    static class Distance implements Comparable<Distance> {
        long totalLen;
        long numTitans;
        long numShamans;

        public Distance(long totalLen, long numTitans, long numShamans) {
            this.totalLen = totalLen;
            this.numTitans = numTitans;
            this.numShamans = numShamans;
        }

        public static Distance Max() {
            return new Distance(Long.MAX_VALUE, Long.MAX_VALUE, Long.MAX_VALUE);
        }

        public Distance add(Edge e) {
            return new Distance(
                    this.totalLen + e.len,
                    this.numTitans + (e.enemy == 2 ? 1 : 0),
                    this.numShamans + (e.enemy == 1 ? 1 : 0)
                    );
        }

        @Override
        public int compareTo(Distance o) {
            if (this.numTitans < o.numTitans) return -1;
            if (this.numTitans > o.numTitans) return 1;
            if (this.numShamans < o.numShamans) return -1;
            if (this.numShamans > o.numShamans) return 1;
            return Long.compare(this.totalLen, o.totalLen);
        }
    }

    static class Edge {
        int toVertex;
        long len;
        int enemy;

        public Edge(int to, long len, int enemy) {
            this.toVertex = to;
            this.len = len;
            this.enemy = enemy;
        }
    }

}