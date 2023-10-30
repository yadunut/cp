package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// Course Schedule
public class L207 {

    HashMap<Integer, ArrayList<Integer>> preMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean dfs(int course) {
        if (visited.contains(course)) return false;
        if (preMap.get(course).size() == 0) return true;
        visited.add(course);
        for (int pre : preMap.get(course)) {
            if (!dfs(pre)) return false;
        }
        preMap.get(course).clear();
//        Have to remove visited notes after to prevent issues such as
//        0 -->       1 --> 2
//        0 --> 3 --> 1
//        If 1 isn't removed after DFS from 0 --> 1 --> 2, then it'll error for 0 --> 3 --> 1 as 1 is "visited" again, but no cycles

        visited.remove(course);
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) preMap.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) {
            preMap.get(pair[0]).add(pair[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        L207 s = new L207();
        System.out.println(s.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(s.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
