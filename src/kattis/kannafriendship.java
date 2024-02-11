import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            int res = this.start - o.start;
            if (res != 0) return res;
            return this.end - o.end;
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
        PrintWriter pr = new PrintWriter(System.out);
        String[] tokens = br.readLine().split(" ");
        // this will keep track of the intervals
        TreeSet<Interval> set = new TreeSet<>();
        int total = 0;

        int numQueries = Integer.parseInt(tokens[1]);
        for(int l = 0; l < numQueries; l++) {
            tokens = br.readLine().split(" ");
            if (tokens[0].equals("1")) {
                Interval interval = new Interval(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                // if the interval is oustide the range of the current set
                if (set.size() == 0 || set.first().start > interval.end || set.last().end < interval.start) {
                    set.add(interval);
                    total += interval.numTracks();
                    continue;
                }
                // This will be the set of all elements that are in range / greater than the interval
                Set<Interval> tailSet;

                // the greatest interval that is smaller than tailset. This will provide us the starting point to run the merge sort on
                Interval floor = set.floor(interval);
                // This floor can be null. If it is, you need to start from the beginning
                if (floor == null) {
                    tailSet = set;
                } else {
                    tailSet = set.tailSet(floor, true);
                }
                // the list of elements to remove as you can't update a set from within a iterator
                ArrayList<Interval> toRemove = new ArrayList<>();
                for (Interval curr : tailSet) {
                    if (interval.end < curr.start) {
                        break;
                    }
                    // interval is within the range of the current elements
                    // absorb the current into the interval
                    if (interval.start <= curr.end) {
                        interval.start = Math.min(interval.start, curr.start);
                        interval.end = Math.max(interval.end, curr.end);
                        toRemove.add(curr);
                        total -= curr.numTracks();
                    }
                }
                // remove all the elements that need to be removed
                toRemove.forEach(set::remove);
                set.add(interval);

                total += interval.numTracks();
            } else {
                pr.println(total);
            }
        }
        pr.close();
    }
}
