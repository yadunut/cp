import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kannafriendship {
    static class Interval implements Comparable<Interval> {
        int start;
        int end;

        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        int numTracks() {
            return this.end - this.start + 1;
        }

        @Override
        public int compareTo(Interval o) {
            return this.start - o.start;
        }

        @Override
        public String toString() {
            return "I{" + "s=" + start + ", e=" + end + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (start != interval.start) return false;
            return end == interval.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        TreeSet<Interval> set = new TreeSet<>();
        int total = 0;
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        while (Q-- > 0) {
            tokens = br.readLine().split(" ");
            if (tokens[0].equals("1")) {
                Interval interval = new Interval(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                if (set.size() == 0) {
                    set.add(interval);
                    total += interval.numTracks();
                    continue;
                }
                boolean append = true;
                TreeSet<Interval> tailSet;
                // all these operations are bad. What if i keep a remove collection
                if (set.floor(interval) == null) {
                    tailSet = new TreeSet<>(set);
                } else {
                    tailSet = new TreeSet<>(set.tailSet(set.floor(interval), true));
                }
                for (Interval curr : tailSet) {
                    if (interval.end < curr.start) {
                        set.add(interval);
                        total += interval.numTracks();
                        append = false;
                        break;
                    }
                    if (interval.start <= curr.end) {
                        interval.start = Math.min(interval.start, curr.start);
                        interval.end = Math.max(interval.end, curr.end);
                        set.remove(curr);
                        total -= curr.numTracks();
                    }
                }
                if (append) {
                    set.add(interval);
                    total += interval.numTracks();
                }
//                System.out.println(list);
            } else {
                System.out.println(total);
            }
        }
    }
}
