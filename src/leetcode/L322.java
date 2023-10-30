package leetcode;

import java.util.Arrays;

// Coin Change
public class L322 {
    public int coinChange(int[] coins, int amount) {
        int cache[] = new int[amount + 1];
        Arrays.fill(cache, amount + 1);
        cache[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c = 0; c < coins.length; c++) {
                int left = a - coins[c];
                if (left >= 0) cache[a] = Math.min(cache[a], 1 + cache[left]);
            }
        }
        if (cache[amount] == amount + 1) return -1;
        return cache[amount];
    }

    public static void main(String[] args) {
        L322 s = new L322();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{1}, 0));
    }
}
