package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// Course Schedule II
public class L210 {
    HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) adjacencyList.put(i, new ArrayList<>());
        for (int[] pair : prerequisites) {
            adjacencyList.get(pair[0]).add(pair[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!bfs(course)) return new int[]{};
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    boolean bfs(int course) {
        if (visited.contains(course)) return false;
        if (adjacencyList.get(course).size() == 0) {
            if (!result.contains(course)) result.add(course);
            return true;
        }
        visited.add(course);
        for (int reqCourse : adjacencyList.get(course)) {
            if (!bfs(reqCourse)) return false;
        }
        adjacencyList.get(course).clear();
        visited.remove(course);
        if (!result.contains(course)) result.add(course);
        return true;
    }

    public static void main(String[] args) {
        L210 s = new L210();
        System.out.println(Arrays.toString(s.findOrder(4, new int[][]{
                {1, 0}, {2, 0}, {3, 1}, {3, 2}
        })));
    }
}
