package leetcode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

// Number of Islands
public class L200 {
    HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
    int rows, cols;
    int numIslands = 0;

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(new Pair<>(r, c))) {
                    bfs(grid, r, c);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    void bfs(char[][] grid, int row, int col) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        visited.add(new Pair<>(row, col));
        queue.add(new Pair<>(row, col));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            for (int[] dir : dirs) {
                int r = dir[0] + curr.getKey();
                int c = dir[1] + curr.getValue();
                if (r < 0 || r >= rows) continue;
                if (c < 0 || c >= cols) continue;
                if (grid[r][c] == '0') continue;
                Pair<Integer, Integer> newP = new Pair<>(r, c);
                if (visited.contains(newP)) continue;
                queue.add(newP);
                visited.add(newP);
            }
        }
    }

}
