package leetcode;

public class L104 {
    public int maxDepth(TreeNode root) {
        return 1 + dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }
}
