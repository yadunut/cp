import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class jetpack {
    static char[][] lines;
    static int cols;
    static int rows = 10;

    static Queue<Integer> moves = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);

        cols = Integer.parseInt(br.readLine());

        lines = new char[rows][cols];
        HashMap<Coord, Coord> result = new HashMap<>();

        for (int i = rows - 1; i >= 0; i--)
            lines[i] = br.readLine().toCharArray();

//        for (char[] line : lines) {
//            System.out.println(Arrays.toString(line));
//        }

        Queue<Coord> moves = new ArrayDeque<>();
        Coord initial = new Coord(0, 0, 0);
        moves.add(initial);

        while (!moves.isEmpty()) {
            Coord move = moves.poll();
//            System.out.printf("%s: %c\n", move, lines[move.row][move.col]);
            if (lines[move.row][move.col] == 'X') continue;
            if (move.col == cols - 1) {
                // handle success case
                // path:
                Coord curr = move;
                ArrayList<Coord> path = new ArrayList<>();
                while (curr != initial) {
                    path.add(curr);
                    curr = result.get(curr);
                }

                Collections.reverse(path);
//                path.forEach(System.out::println);

                ArrayList<int[]> out = new ArrayList<>();
                int count = 0, first = -1;
                for (int i = 0; i < path.size(); i++) {
                    if (path.get(i).move == 1) count++;
                    else {
                        if (count == 0) {
                            first = i + 1;
                            continue;
                        }
                        out.add(new int[]{first, count});
                        first = i + 1;
                        count = 0;
                    }
                }

                if (count > 0) out.add(new int[]{first, count});
                pr.println(out.size());
                for (int[] ints : out) {
                    pr.printf("%d %d\n", ints[0], ints[1]);
                }
                pr.close();
                return;
            }
            Coord up = new Coord(move.col + 1, move.row + 1, 1);
            Coord down = new Coord(move.col + 1, move.row - 1, -1);
            if (!result.containsKey(down)) {
                result.put(down, move);
                moves.add(down);
            }
            if (!result.containsKey(up)) {
                result.put(up, move);
                moves.add(up);
            }
        }
        pr.flush();
    }

    static class Coord {
        int col;
        int row;
        // eithe 0 (first), 1 (up) or 0(down)
        int move;

        Coord(int x, int y, int move) {
            if (x < 0) this.col = 0;
            else if (x >= cols) this.col = cols - 1;
            else this.col = x;
            if (y < 0) this.row = 0;
            else if (y >= 10) this.row = 9;
            else this.row = y;

            this.move = move;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "col=" + col +
                    ", row=" + row +
                    ", move=" + move +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coord coord = (Coord) o;

            if (col != coord.col) return false;
            if (row != coord.row) return false;
            return move == coord.move;
        }

        @Override
        public int hashCode() {
            int result = col;
            result = 31 * result + row;
            result = 31 * result + move;
            return result;
        }
    }
}

