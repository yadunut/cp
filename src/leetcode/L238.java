package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// Product of Array Except Self
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int preFix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = preFix;
            preFix *= nums[i];
        }
        int postFix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postFix;
            postFix *= nums[i];
        }
        return result;
    }

    public int[] productExceptSelfWrong(int[] nums) {
        ArrayList<Integer> zeros = new ArrayList<>();
        int[] result = new int[nums.length];
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zeros.add(i);
            else prod *= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeros.size() != 0) {
                    result[i] = 0;
                } else {
                    result[i] = prod / nums[i];
                }
            } else {
                int finalI = i;
                long numZeros = zeros.stream().filter(item -> item != finalI).count();
                if (numZeros > 0) result[i] = 0;
                else result[i] = prod;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L238 s = new L238();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
