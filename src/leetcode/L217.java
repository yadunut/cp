package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// Contains Duplicate
public class L217 {
    public boolean containsDuplicateSlow(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) return true;
            prev = nums[i];
        }
        return false;
    }
    public boolean containsDuplicateHash(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int num: nums){
            if (s.contains(num)) return true;
            s.add(num);
        }
        return false;
    }
}
