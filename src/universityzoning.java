import java.util.*;

public class universityzoning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextDouble(); // rows
        sc.nextDouble(); // columns
        int F = sc.nextInt(); // num faculties
        int S = sc.nextInt(); // num students
        int G = sc.nextInt(); // compliant faculties

        int moves = 0;

        ArrayList<Faculty> faculties = new ArrayList<>();

        for (int i = 0; i < F; i++) {
            int numCells = sc.nextInt();
            faculties.add(new Faculty());
            for (int j = 0; j < numCells; j++) {
                faculties.get(i).cells.add(new Coord(sc.nextInt(), sc.nextInt()));
            }
        }

        for (int i = 0; i < S; i++) {
            Coord coord = new Coord(sc.nextInt(), sc.nextInt());
            int id = sc.nextInt();
            int f = sc.nextInt() - 1;
            // if student is already in valid cell, remove cell
            if (faculties.get(f).cells.contains(coord)) {
                faculties.get(f).cells.remove(coord);
                faculties.get(f).minStudents--;
                continue;
            }
            faculties.get(f).students.add(new Student(coord, id));
        }

        ArrayList<Faculty> fToRemove = new ArrayList<>();
        for (int i = 0; i < F; i++) {
            faculties.get(i).minStudents += sc.nextInt();
            if (faculties.get(i).minStudents <= 0) {
                fToRemove.add(faculties.get(i));
                G--;
            }
        }

        if (G <= 0) {
            System.out.println(moves);
            return;
        }
        fToRemove.forEach(faculties::remove);

        faculties.forEach(f -> {
            f.students.sort(Comparator.comparingInt(a -> a.id));
            f.cells.sort(Comparator.comparingInt(a -> a.x));
            for (int i = 0; i < f.students.size(); i++) {
                Student s = f.students.get(i);
                Coord c = f.cells.get(i);
                f.distances.add(Math.abs(s.coord.x - c.x) + Math.abs(s.coord.y - c.y));
            }
            f.distances.sort(Comparator.comparingInt(Number::intValue));
            for (int i = 0; i < f.minStudents; i++) {
                f.minTotalDistance += f.distances.get(i).intValue();
            }
        });

        faculties.sort(Comparator.comparingInt(f -> f.minTotalDistance));
        // now I need to add up the minimum faculties needed
        for (; G > 0; G--) {
            for (Faculty f : faculties) {
                moves += f.minTotalDistance;
            }
        }
        System.out.println(moves);
    }
}

class Faculty {
    public final ArrayList<Coord> cells = new ArrayList<>();
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<Number> distances = new ArrayList<>();
    public int minStudents = 0;

    public int minTotalDistance = 0;

    @Override
    public String toString() {
        return "Faculty{" +
                "cells=" + cells +
                ", students=" + students +
                ", minStudents=" + minStudents +
                '}';
    }
}

class Student {
    public final Coord coord;
    public final int id;

    Student(Coord coord, int id) {
        this.coord = coord;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "coord=" + coord +
                ", id=" + id +
                '}';
    }
}

class Coord {
    final int x;
    final int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}