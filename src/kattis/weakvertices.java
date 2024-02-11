import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class weakvertices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for(int[]a : map) {
            for(int b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            boolean weak = true;
            for(int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                for(int k = 0; k < n; k++) {
                    if (map[k][i] == 1) {
                        weak = false;
                        break;
                    }
                    if (weak) break;
                }
            }
            if (weak) System.out.println(i);
        }
        // build matrix
    }
}
