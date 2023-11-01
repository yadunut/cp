package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//501. Find Mode in Binary Search Tree
public class L501 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int currVal;
    int currCount = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        currCount = currVal == root.val ? currCount + 1 : 1;
        if (currCount == maxCount) {
            result.add(root.val);
        } else if (currCount > maxCount) {
            maxCount = currCount;
            result.clear();
            result.add(root.val);
        }
        currVal = root.val;
        inOrder(root.right);
    }
}
