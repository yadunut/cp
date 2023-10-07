package leetcode;

import java.util.*;

public class L57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        // if new interval is before the itervals
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                result.add(newInterval);
                Collections.addAll(result, Arrays.copyOfRange(intervals, i, intervals.length));
                return result.toArray(new int[][]{});
            } else if (newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else {
                newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            }
        }
        result.add(newInterval);
        return result.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        L57 s = new L57();
        int[][] result = s.insert(new int[][]{
                        new int[]{1, 3},
                        new int[]{6, 9}
                }, new int[]{2, 5}
        );
        for (int[] ints : result) {
            System.out.printf("[%d %d]", ints[0], ints[1]);
        }
    }
}
