import java.util.ArrayList;
import java.util.Scanner;

public class jobbyte {
    // logic: Go through each item in the ar. if the value is -1, continue.
    // If not, follow the id, increment swaps
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt() + 1;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(-1);
        int swaps = 0;

        for (int i = 1; i < N; i++) arr.add(sc.nextInt());

        for (int i = 1; i < N; i++) {
            int currIdx = i;
            int currVal = arr.get(currIdx);
            if (currVal == i) continue;
            if (currVal == -1) continue;

            while(currVal != -1) {
                swaps++;
                arr.set(currIdx, -1);
                currIdx = currVal;
                currVal = arr.get(currIdx);
            }

            swaps--;

        }
        System.out.println(swaps);
    }
}