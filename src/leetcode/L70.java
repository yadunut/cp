package leetcode;

public class L70 {
    public static int climbStairs(int n) {
        int a = 1, b = 1, curr;
        while(n-- > 0) {
            curr = a + b;
            a = b;
            b = curr;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
