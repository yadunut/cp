package leetcode;

import java.util.HashMap;
import java.util.Map;

//501. Find Mode in Binary Search Tree
public class L501 {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        map.compute(root.val, (val, freq) -> freq != null ? freq+1 : 1);
        maxFreq = Math.max(maxFreq, map.get(root.val));
        findMode(root.left);
        findMode(root.right);
        return map.entrySet().stream().filter((v) -> v.getValue() == maxFreq).mapToInt(Map.Entry::getKey).toArray();
    }
}
