package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curr = new ArrayList<>();
            int currLen = queue.size();
            while (currLen-- > 0) {
                TreeNode cNode = queue.pop();
                curr.add(cNode.val);
                if (cNode.left != null) queue.add(cNode.left);
                if (cNode.right != null) queue.add(cNode.right);
            }
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        L102 s = new L102();
    }
}
