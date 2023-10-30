package leetcode;

// Balanced Binary Tree
public class L110 {
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    static int height(TreeNode n) {
        if (n == null) return 0;
        int hLeft = height(n.left);
        int hRight = height(n.right);
        if (hLeft ==-1 || hRight == -1) return -1;
        if (Math.abs(hLeft - hRight) > 1) return -1;
        return 1+Math.max(hLeft, hRight);
    }
}
