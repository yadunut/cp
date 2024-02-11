import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class continuousmedian {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.comparingInt(i -> -i));
        PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.comparingInt(i -> i));

        int Tc = Integer.parseInt(br.readLine());
        while(Tc-- > 0) {
            int nums = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());

            }
        }


        pr.close();
    }
}