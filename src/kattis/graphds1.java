import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

class graphds1 {
    static ArrayList<ArrayList<Integer>> AL = new ArrayList<>();
    static int numVertices;
    static int numEdges;
    static boolean undirected;
    static HashSet<Integer> roots = new HashSet<>();
    static ArrayList<Integer> visited = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        numVertices = Integer.parseInt(st.nextToken());
        numEdges = Integer.parseInt(st.nextToken());
        undirected = Integer.parseInt(st.nextToken()) == 1;

        for (int i = 0; i < numVertices; i++) {
            AL.add(new ArrayList<>());
            visited.add(0);
            roots.add(i);
        }
        for (int i = 0; i < numEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            roots.remove(to);
            AL.get(from).add(to);
            if (undirected)
                AL.get(to).add(from);
        }
        // System.out.println(AL);
        boolean isTree = isTree();
        System.out.print(isTree ? "1 " : "0 ");
        boolean complete = numEdges == (numVertices * (numVertices - 1)) / 2;
        System.out.print(complete ? "1 " : "0 ");
        System.out.print(isTree ? "1 " : "0 ");
        System.out.println(isTree && !undirected ? "1 " : "0 ");
    }

    public static boolean isTree() {
        if (numEdges != numVertices - 1)
            return false;
        // dfs from here
        Stack<Integer> s = new Stack<>();
        int starting = roots.stream().findFirst().get();
        s.add(starting);
        s.addAll(AL.get(starting));
        while (!s.isEmpty()) {
            int curr = s.pop();
            visited.set(curr, 1);
            for (int neighbour : AL.get(curr)) {
                if (visited.get(neighbour) == 0)
                    s.push(neighbour);
            }
        }
        // System.out.println(visited);
        for (int i = 0; i < numVertices; i++) {
            if (visited.get(i) == 0)
                return false;
        }
        return true;
    }
}
