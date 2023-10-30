import javafx.util.Pair;

import java.util.*;

// Rotting Oranges
public class L994 {

    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        int numFresh = 0;
        int minutes = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) numFresh++;
                if (grid[x][y] == 2) queue.add(new Pair<>(x, y));
            }
        }
        // loop while there are rotten or fresh apples
        while (!queue.isEmpty() && numFresh > 0) {
            int size = queue.size();
//            System.out.printf("%d min, Processing queue, %d items\n", minutes, size);
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> curr = queue.poll();
                // add 4 directions to the list
//                        System.out.printf("Currently processing grid[%d][%d]=%d decision: add ", curr.getKey(), curr.getValue(), grid[curr.getKey()][curr.getValue()]);
                for (int[] dir : dirs) {
                    int x = curr.getKey() + dir[0];
                    int y = curr.getValue() + dir[1];
                    Pair<Integer, Integer> newCoord = new Pair<>(x, y);
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
//                                System.out.printf("[%d %d] ", x, y);
                        grid[x][y] = 2;
                        numFresh--;
                        queue.add(newCoord);
                    }
                }
            }
            minutes++;
        }
        if (queue.isEmpty() && numFresh > 0) return -1;
        return minutes;
    }

    public static void main(String[] args) {
        L994 s = new L994();
        System.out.println(s.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
        System.out.println(s.orangesRotting(new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        }));
    }
}
