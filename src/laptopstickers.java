import java.util.Scanner;

public class laptopstickers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // columns
        int H = sc.nextInt(); // rows
        char result[][] = new char[H][L];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < L; j++) {
                result[i][j] = '_';
            }
        }
        int K = sc.nextInt();

        for(int i = 0; i< K; i++) {
            int length = sc.nextInt();
            int height = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int c = 0; c < height; c++) {
                for (int d = 0; d < length; d++) {
                    try {
                        result[c+b][a+d] = (char) ('a' + i);
                    }catch (Exception e) {
                        continue;
                    }
                }
            }
        }
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < L; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
