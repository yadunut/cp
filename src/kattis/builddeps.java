import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//  for some reason i was failing testcase, referencing steven halim's code
public class builddeps {
    private static HashSet<String> visited;
    private static HashMap<String, ArrayList<String>> deps;
    private static ArrayList<String> toposort;

    private static void dfs(String u) {
        visited.add(u);
        if (deps.get(u) != null) {
            for(String v : deps.get(u)) {
                if (!visited.contains(v)) dfs(v);
            }
        }
        toposort.add(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        deps = new HashMap<>();
        visited = new HashSet<>();
        toposort = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String f = st.nextToken(":");
            while(st.hasMoreTokens()) {
                String d = st.nextToken(" ");
                deps.computeIfAbsent(d, k -> new ArrayList<>());
                deps.get(d).add(f);
            }
        }
        dfs(br.readLine());

        for(int i = toposort.size()-1; i >= 0; i--) System.out.println(toposort.get(i));
    }
}
