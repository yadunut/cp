package leetcode;

import java.util.Stack;
import javafx.util.Pair;

public class L733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Stack<Pair<Integer, Integer>> s = new Stack<>();
        int currColor = image[sr][sc];
        s.push(new Pair<>(sr,sc));
        while(!s.empty()) {
            Pair<Integer, Integer> c = s.pop();
            if (image[c.getKey()][c.getValue()] != currColor) continue;
            if (image[c.getKey()][c.getValue()] == color) continue;
            image[c.getKey()][c.getValue()] = color;
            if (c.getKey() - 1 >= 0) s.push(new Pair<>(c.getKey()-1,c.getValue()));
            if (c.getKey() + 1 < image.length) s.push(new Pair<>(c.getKey()+1,c.getValue()));
            if (c.getValue() - 1 >= 0) s.push(new Pair<>(c.getKey(),c.getValue()-1));
            if (c.getValue() + 1 < image[0].length) s.push(new Pair<>(c.getKey(),c.getValue()+1));
        }
        return image;
    }
}


