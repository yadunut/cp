import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class universityzoning {
    public static void main(String[] args) throws IOException {
        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int F, S, G;
        {
            String[] tokens = bi.readLine().split(" ");
            F = Integer.parseInt(tokens[2]); // num faculties
            S = Integer.parseInt(tokens[3]); // num students
            G = Integer.parseInt(tokens[4]); // compliant faculties
        }

        long moves = 0;

        ArrayList<Faculty> faculties = new ArrayList<>();

        // populate the faculties
        for (int i = 0; i < F; i++) {
            String[] tokens = bi.readLine().split(" ");
            int numCells = Integer.parseInt(tokens[0]);
            faculties.add(new Faculty());
            for (int j = 0; j < numCells; j++) {
                faculties.get(i).cells.add(new Coord(Long.parseLong(tokens[2 * j + 1]), Long.parseLong(tokens[2 * j + 2])));
            }
        }

        // populate the students in each faculty
        for (int i = 0; i < S; i++) {
            String[] tokens = bi.readLine().split(" ");
            Coord coord = new Coord(Long.parseLong(tokens[0]), Long.parseLong(tokens[1]));
            long id = Long.parseLong(tokens[2]);
            int f = Integer.parseInt(tokens[3]) - 1;
            faculties.get(f).students.add(new Student(coord, id));
        }

        String[] tokens = bi.readLine().split(" ");
        for (int i = 0; i < F; i++) {
            faculties.get(i).minStudents = Integer.parseInt(tokens[i]);
        }

        faculties.forEach(f -> {
            f.students.sort(Comparator.comparingLong(a -> a.id));
            f.cells.sort(Comparator.comparingLong((Coord a) -> a.row).thenComparingLong(a -> a.col)); // sort the cells based on row, so that the highest cells (cells closest to 0, would be at the top)
            // calculate the distances for each student[i] and cell[i]
            for (int i = 0; i < f.students.size(); i++) {
                Student s = f.students.get(i);
                Coord c = f.cells.get(i);
                f.distances.add(Math.abs(s.coord.row - c.row) + Math.abs(s.coord.col - c.col));
            }
            // after sorting, the i-th distance would be the i-th shortest path for the student
            f.distances.sort(Comparator.comparingLong(Number::longValue));
            // compute the minimum distance for this faculty to be compliant
            for (int i = 0; i < f.minStudents; i++) {
                f.minTotalDistance += f.distances.get(i).longValue();
            }
        });

        // sort the faculties on minimum distance needed
        faculties.sort(Comparator.comparingLong(f -> f.minTotalDistance));
        // now I need to add up the minimum faculties needed
        for (int i = 0; i < G; i++) {
            moves += faculties.get(i).minTotalDistance;
        }
        System.out.println(moves);
    }
}

class Faculty {
    public final ArrayList<Coord> cells = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Number> distances = new ArrayList<>();
    public int minStudents = 0;
    public long minTotalDistance = 0;
}

class Student {
    public final Coord coord;
    public final long id;

    Student(Coord coord, long id) {
        this.coord = coord;
        this.id = id;
    }
}

class Coord {
    final long row;
    final long col;

    Coord(long x, long y) {
        this.row = x;
        this.col = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return row == coord.row && col == coord.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}