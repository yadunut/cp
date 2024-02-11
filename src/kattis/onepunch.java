import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class onepunch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        int numTests = Integer.parseInt(st.nextToken());

        ArrayList<char[]> maze = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            maze.add(br.readLine().toCharArray());
        }
        for (int i = 0; i < numTests; i++) {
            st = new StringTokenizer(br.readLine());
        }
    }
}
