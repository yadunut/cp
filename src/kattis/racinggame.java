import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class racinggame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int numOps = Integer.parseInt(br.readLine());

        int acc = 0;

        ArrayList<Integer> scores = new ArrayList<>();

        for (int i = 0; i < numOps; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());

            if (op == 1) {
                int score = Integer.parseInt(st.nextToken());
                if (scores.size() == 10) {
                    scores.sort(Comparator.comparingInt(v -> v));
                    scores.set(scores.size()-1, Math.min(score, scores.get(scores.size()-1)));
                } else {
                    scores.add(score);
                }
            } else if (op == 2) {
                int val = Integer.parseInt(st.nextToken());
                for (int s = 0; s < scores.size(); s++) scores.set(s, scores.get(s) + val);
//                acc += val;
            } else {
                int val = Integer.parseInt(st.nextToken()) - 1;
                scores.sort(Comparator.comparingInt(v -> v));
                pr.println(scores.get(val));
            }
        }
        pr.close();
    }
}
