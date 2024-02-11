import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class arraysmoothening {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        HashMap<Integer, Integer> freq = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            freq.compute(num, (i, f) -> f == null ? 1 : f + 1);
            max = Math.max(max, freq.get(num));
        }
        System.out.println(max);
    }
}