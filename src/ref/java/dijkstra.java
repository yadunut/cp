package ref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dijkstra {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numVertices = Integer.parseInt(st.nextToken());
        int numEdges = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // class of id and weights
        ArrayList<ArrayList<Edge>> AL = new ArrayList<>();
        for (int i = 0; i < numVertices; i++)
            AL.add(new ArrayList<>());
        for (int i = 0; i < numEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            AL.get(from).add(new Edge(to, weight));
            AL.get(to).add(new Edge(from, weight)); // if bidirectional
        }

        // distance from vertex
        ArrayList<Distance> dist = new ArrayList<>();
        for (int i = 0; i < numVertices; i++)
            dist.add(Distance.Max());
        dist.set(start, new Distance(0));

        TreeSet<Pair> pq = new TreeSet<>();
        for (int i = 0; i < numVertices; i++)
            pq.add(new Pair(dist.get(i), i));

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
        System.out.println(dist.get(end));
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
                return 1;
            return res;
        }
    }

    static class Distance implements Comparable<Distance> {
        int totalWeight;

        public Distance(int t) {
            this.totalWeight = t;
        }

        public static Distance Max() {
            return new Distance(Integer.MAX_VALUE);
        }

        public Distance add(Edge e) {
            return new Distance(this.totalWeight + e.weight);
        }

        @Override
        public int compareTo(Distance o) {
            return this.totalWeight - o.totalWeight;
        }
    }

    static class Edge {
        int toVertex;
        int weight;

        public Edge(int to, int weight) {
            this.toVertex = to;
            this.weight = weight;
        }
    }
}
