import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class bokforing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int N, Q;
        {
            String[] tokens = br.readLine().split(" ");
            N = Integer.parseInt(tokens[0]);
            Q = Integer.parseInt(tokens[1]);
        }
        HashMap<String, String> map = new HashMap<>(N);
        String defaultVal = "0";
        for (int i = 0; i < Q; i++) {
            String[] tokens = br.readLine().split(" ");
            if (tokens[0].equals("SET")) {
                map.put(tokens[1], tokens[2]);
            } else if (tokens[0].equals("PRINT")) {
                pr.println(map.getOrDefault(tokens[1], defaultVal));
            } else {
                defaultVal = tokens[1];
                map = new HashMap<>();
            }
        }
        pr.flush();
    }
}
