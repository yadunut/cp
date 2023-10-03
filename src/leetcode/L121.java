package leetcode;

public class L121 {
    public static int maxProfit(int[] prices) {
        int buy = prices[0], profit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            if (prices[i] < buy) buy = prices[i]; // get the lowest buy value

            if (profit < prices[i] - buy) profit = prices[i] - buy;
        }
        return profit;
    }

    public static int maxProfit2Ptr(int[] prices) {
        int buy = 0;
        int sell = 1;
        int profit = 0;
        while(sell < prices.length) {
            if (prices[sell]  > prices[buy]) {
                profit = Math.max(profit, prices[sell] - prices[buy]);
            }
            else {
                buy = sell;
            }
            sell++;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
