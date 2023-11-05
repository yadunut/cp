package leetcode;

import java.util.*;

// 1535. Find the Winner of an Array Game
class L1535 {
        public int getWinner(int[] arr, int k) {
        int wins = 0;
        int a = arr[0];
        List<Integer> nums = new ArrayList<>();

        int biggest = arr[0];

        for (int v : arr) {
            nums.add(v);
            biggest = Math.max(biggest, v);
        }

        if (k > arr.length) return biggest;


        while (wins != k) {
            a = nums.get(0);
            int b = nums.get(1);

            if (a > b) {
                wins++;
                nums.add(nums.remove(1));
            } else {
                wins = 1;
                a = b;
                nums.add(nums.remove(0));
            }
        }
        return a;
    }

    public static void main(String[] args) {
        L1535 s = new L1535();
        System.out.println(s.getWinner(new int[] { 2, 1, 3, 5, 4, 6, 7 }, 2));
        System.out.println(s.getWinner(new int[] {3,2,1}, 10));
    }
}
