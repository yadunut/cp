import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class teque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        HashMap<Long, Long> front = new HashMap<>();
        HashMap<Long, Long> back = new HashMap<>();
        long frontF = -1, frontB = 0, backF = -1, backB = 0;
        long N = Long.parseLong(br.readLine());
        while (N-- > 0) {
            String[] tokens = br.readLine().split(" ");
            long res = Long.parseLong(tokens[1]);
            switch (tokens[0]) {
                case "get": {
                    if (res >= front.size()) {
                        // it belongs in the back
                        long idx = res - front.size() + backF + 1;
                        pr.println(back.get(idx));
                    } else {
                        long idx = res + frontF + 1;
                        pr.println(front.get(idx));
                    }
                    break;
                }
                case "push_back": {
                    back.put(backB++, res);
                    break;
                }
                case "push_front": {
                    front.put(frontF--, res);
                    break;
                }
                case "push_middle": {
                    front.put(frontB++, res);
                    break;
                }
            }
            // handle balancing
            if (front.size() - back.size() > 1) {
                // while front is bigger than back by 1
                back.put(backF--, front.remove(--frontB));
            }
            if (back.size() - front.size() > 1) {
                // while front is bigger than back by 1
                front.put(frontB++, back.remove(--backF));
            }
        }
        pr.flush();
        pr.close();
    }
}
