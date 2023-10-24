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
            return "I{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        List<Interval> list = new ArrayList<>();
        int total = 0;
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        while (Q-- > 0) {
            tokens = br.readLine().split(" ");
            if (tokens[0].equals("1")) {
                Interval interval = new Interval(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                if (list.size() == 0) {
                    list.add(interval);
                    total += interval.numTracks();
                    continue;
                }
                // iterate through every single interval and try to see if valid insertion point
                boolean append = true;
                for (int i = 0; i < list.size(); i++) {
                    Interval curr = list.get(i);
                    // new interval.end < current interval.start
                    if (interval.end < curr.start) {
                        list.add(i, interval);
                        total += interval.numTracks();
                        append = false;
                        break;
                    }
                    // new interval.start > current interval end
                    else if (interval.start > curr.end) continue;
                    else {
                        // within range
                        interval.start = Math.min(interval.start, curr.start);
                        interval.end = Math.max(interval.end, curr.end);
                        list.remove(i);
                        total -= curr.numTracks();
                        i--;
                    }
                }
                if (append) {
                    list.add(interval);
                    total += interval.numTracks();
                }
//                System.out.println(list);
            } else {
                System.out.println(total);
            }
        }
    }
}
