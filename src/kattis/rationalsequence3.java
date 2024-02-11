import java.util.HashMap;
import java.util.Scanner;

public class rationalsequence3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, int[]> cache = new HashMap<>();
        cache.put(1, new int[]{1, 1});
        int tests = sc.nextInt();

        for (int i = 0; i < tests; i++) {
            int index = sc.nextInt();
            int val = sc.nextInt();

            int[] result = F(val, cache);
            System.out.printf("%d %d/%d\n", index, result[0], result[1]);
        }

    }

    static int[] F(int val, HashMap<Integer, int[]> cache) {
        // F(5) = (F(2)[0] + F(2)[1]) / F(2)[1]
        if (cache.containsKey(val)) return cache.get(val);
        int[] parent = F(val / 2, cache);
        int[] result;
        if (val % 2 == 0) {
            result = new int[]{(parent[0]), parent[0] + parent[1]};
        } else {
            result = new int[]{(parent[0] + parent[1]), parent[1]};
        }
        cache.put(val, result);
        return result;
    }
}
