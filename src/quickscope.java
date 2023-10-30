import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class quickscope {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        Stack<HashMap<String, String>> environments = new Stack<>();
        environments.push(new HashMap<>());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
//            System.out.println("PRocessing " +  line);
            StringTokenizer ts = new StringTokenizer(line);
            char OP = ts.nextToken().charAt(0);

            if (OP == 'T') {
                String var = ts.nextToken();
                pr.println(environments.peek().getOrDefault(var, "UNDECLARED"));
            } else if (OP == 'D') {
                String var = ts.nextToken();
                String type = ts.nextToken();
                HashMap<String, String> currEnv = environments.peek();
                if (!currEnv.containsKey(var)) {
                    currEnv.put(var, type);
                } else {
                    environments.pop();
                    if (environments.size() == 0 || !environments.peek().containsKey(var)) {
                        pr.println("MULTIPLE DECLARATION");
                        pr.close();
                        return;
                    }
                    // previous environment contains but this is redelcaration
                    currEnv.put(var, type);
                    environments.push(currEnv);
                }
            } else if (OP == '{') {
                environments.push(new HashMap<>(environments.peek()));
            } else {
                environments.pop();
            }
        }
        pr.close();
    }
}