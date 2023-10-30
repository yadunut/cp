package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L11 {
    // Container with most water
    public int maxArea(int[] height) {
        int maxWater = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxWater;
    }

    public int maxAreaNotWorking(int[] height) {
        PriorityQueue<int[]> points = new PriorityQueue<>(Comparator.comparingInt(p -> -p[0]));
        for (int i = 0; i < height.length; i++) {
            if (i < height.length / 2) points.add(new int[]{height[i] * (height.length / 2 - i), i});
            else points.add(new int[]{height[i] * (i - height.length / 2 + 1), i});
        }
        int left = points.poll()[1];
        int right = points.poll()[1];

        return Math.min(height[left], height[right]) * (Math.abs(right - left));

        // find hte biggest in each half

    }

    public int maxAreaO2(int[] height) {
        int maxArea = 0;
        // worst case, nested for loop. Other method is 2 pointers, moving the smaller one
        // its not even finding the local maximum, its findin
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        L11 s = new L11();
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3}));
        System.out.println(s.maxArea(new int[]{1, 1}));
    }
}
