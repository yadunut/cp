import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class onaveragetheyrepurple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Integer>> AL = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (!AL.containsKey(v)) AL.put(v, new ArrayList<>());
            if (!AL.containsKey(e)) AL.put(e, new ArrayList<>());
            AL.get(v).add(e);
            AL.get(e).add(v);
        }

//        System.out.println(AL);

        int[] distances = new int[N+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

//        System.out.println(Arrays.toString(distances));

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if (AL.get(curr) == null) continue;
            for(int v : AL.get(curr)) {
//                System.out.println("v = " + v);
                if (distances[v] != Integer.MAX_VALUE) continue;
                q.add(v);
                distances[v] = Math.min(distances[v], distances[curr]+1);
//                System.out.println(Arrays.toString(distances));
            }
        }


        System.out.println(distances[N]-1);

        pr.close();
    }
}