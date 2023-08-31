import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class gearchanging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int[] crank = new int[N];
        int[] rWheel = new int[M];
        for (int i = 0; i < N; i++) {
            crank[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            rWheel[i] = sc.nextInt();
        }
        ArrayList<Double> powers = new ArrayList<>();
        for (int c : crank) {
            for (int r : rWheel) {
                powers.add((double) c / r);
            }
        }
        powers.sort(Comparator.comparingDouble(a -> a));

        for (int i = 0; i < powers.size() - 1; i++) {
            if (powers.get(i) * ((P / 100.0) + 1) < powers.get(i + 1)) {
                System.out.println("Time to change gears!");
                return;
            }
        }
        System.out.println("Ride on!");
    }
}

/*
2 11 15
50 34
11 12 13 14 16 18 20 22 25 28 32

 */