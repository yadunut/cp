package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

// K Closest Points to Origin
public class L973 {

    static double dist(int a, int b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingDouble(o -> dist(o[0], o[1])));
        Collections.addAll(queue, points);
//        queue.forEach(i -> System.out.printf("[%d %d] ", i[0], i[1]));
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        L973 s = new L973();
        System.out.println(Arrays.deepToString(s.kClosest(new int[][]{
                {1, 3}, {-2, 2}
        }, 1)).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println(Arrays.deepToString(s.kClosest(new int[][]{
                {3, 3}, {5, -1}, {-2, 4}
        }, 2)).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}
