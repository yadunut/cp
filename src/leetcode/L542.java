package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

// 01 Matrix
public class L542 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                // each item in the array
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else
                    mat[i][j] = Integer.MAX_VALUE; // all 1s are set to max, so that when we put in the distance its correct
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];
                    // continue if invalid
                    if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] <= mat[curr[0]][curr[1]]+1)
                        continue;
                    mat[row][col] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[]{row, col});
                    // if row / col is not
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        L542 s = new L542();
        int[][] result = s.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        });
        System.out.println(Arrays.deepToString(result).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

    }
}
