package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class L169 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int biggest = nums[0];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(biggest) < entry.getValue()) biggest = entry.getKey();
        }
        return biggest;
    }

    // using the algorithm
    public static int majorityElementO1(int[] nums) {
        int current = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                current = num;
                count = 1;
            } else if (current == num) count++;
            else count--;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementO1(new int[]{3, 2, 3}));
        System.out.println(majorityElementO1(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElementO1(new int[]{6, 5, 5}));
    }
}
