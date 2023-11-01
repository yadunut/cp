import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class cd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int jack, jill;
        String[] tokens = br.readLine().split(" ");
        jack = Integer.parseInt(tokens[0]);
        jill = Integer.parseInt(tokens[1]);

        HashSet<Integer> cds = new HashSet<>();
        for(int i = 0; i < jack; i++) {
            cds.add(Integer.parseInt(br.readLine()));
        }

        int counter = 0 ;
        for(int i = 0; i < jill; i++) {
            if (cds.contains(Integer.parseInt(br.readLine()))) counter++;
        }
        System.out.println(counter);
    }
}
