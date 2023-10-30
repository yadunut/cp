package leetcode;

// Diameter of Binary Tree
public class L543 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    int dfs(TreeNode root) {
        if (root == null) return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        this.result = Math.max(this.result, 2 + left + right);
        return 1 + Math.max(left, right);
    }


    public static void main(String[] args) {
        L543 s = new L543();
        System.out.println(
                s.diameterOfBinaryTree(TreeNode.createNode(new int[]{1, 2, 3, 4, 5}, 0))
        );
    }

}
