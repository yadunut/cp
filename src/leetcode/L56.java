package leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

// Merge Intervals
public class L56 {
    public int[][] merge(int[][] intervals) {

        Map<String,String> db = new TreeMap<>();
        db.forEach((k,v) -> System.out.println(""));
        String a = "";
        for (Map.Entry<String, String> kkk : db.entrySet()) {
        }
        StringBuilder sb = new StringBuilder();
        List<int[]> sorted = Arrays.stream(intervals).sorted(Comparator.comparingInt(i -> i[0])).collect(Collectors.toList());
        ArrayList<int[]> result = new ArrayList<>();
        int[] curr = sorted.get(0);
        for (int i = 1; i < sorted.size(); i++) {
            int[] interval = sorted.get(i);
            System.out.printf("Curr: %s, interval: %s\n", Arrays.toString(curr), Arrays.toString(interval));
            // check if the next value is within the range of the current interval. if it is, update the end range to the max of current
            if (curr[1] >= interval[0]) curr[1] = Math.max(curr[1], interval[1]);
            else {
                result.add(curr);
                curr = sorted.get(i);
            }
        }
        result.add(curr);
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        L56 s = new L56();
        System.out.println(Arrays.deepToString(s.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}}
        )));
        System.out.println(Arrays.deepToString(s.merge(new int[][]{
                        {1, 4}, {4, 5}
                }
        )));
    }
}
