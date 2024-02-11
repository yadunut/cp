import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class doctorkattis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine());

        ArrayList<Cat>[] cats = new ArrayList[100];
        for (int i = 0; i < 100; i++) cats[i] = new ArrayList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "0": {
                    String name = st.nextToken();
                    int sev = Integer.parseInt(st.nextToken());
                    cats[sev].add(new Cat(name, sev));
                    break;
                }
                case "1": {
                    break;
                }
                case "2": {
                    break;

                }
                case "3": {
                    for (int i = 99; i >= 0; i--) {
                        if (cats[i].size() == 0) continue;
                        pr.println(cats[i].get(cats[i].size() - 1));
                    }
                    break;
                }

            }
        }

        pr.close();
    }

    static class Cat {
        public Cat(String name, int sev) {
            this.name = name;
            this.sev = sev;
        }

        String name;
        int sev;
    }
}