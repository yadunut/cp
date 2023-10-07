package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // do 2 sum from i+1 to find -i.
            int target = -nums[i], left = i + 1, right = nums.length - 1;
            while (left < right) {
                int res = target - (nums[left] + nums[right]);
//                System.out.printf("t: %d, l[%d]: %d, r[%d]: %d\n", target, left, nums[left], right, nums[right]);
                if (res == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) left++;
                } else if (res > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L15 s = new L15();
        System.out.println(s.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.threeSum(new int[]{0,0,0,0}));
        ;
    }
}
