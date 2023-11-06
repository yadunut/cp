import java.util.HashMap;
import java.util.Scanner;

// built heavily referencing Russell's work
public class bokhyllor {
    static int sWidth;
    static HashMap<Entry, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // width 1
        int b = sc.nextInt(); // width 2
        int c = sc.nextInt(); // width 3
        sWidth = sc.nextInt();
        System.out.println(recur(new Entry(a, b, c)));
    }


    static int recur(Entry e) {
        if (e.a == 0 && e.b == 0 && e.c == 0) return e.currWidth > 0 ? 1 : 0;
        if (cache.containsKey(e)) return cache.get(e);
        int currMin = Integer.MAX_VALUE;

        if (e.a > 0) {
            if (e.currWidth <= sWidth - 1) {
                currMin = Math.min(currMin, recur(new Entry(e.a-1, e.b, e.c, e.currWidth+1)));
            } else {
                currMin = Math.min(currMin, 1+recur(new Entry(e.a-1, e.b, e.c, 1)));
            }
        }
        if (e.b > 0) {
            if (e.currWidth <= sWidth - 2) {
                currMin = Math.min(currMin, recur(new Entry(e.a, e.b-1, e.c, e.currWidth+2)));
            } else {
                currMin = Math.min(currMin, 1+recur(new Entry(e.a, e.b-1, e.c, 2)));
            }
        }
        if (e.c > 0) {
            if (e.currWidth <= sWidth - 3) {
                currMin = Math.min(currMin, recur(new Entry(e.a, e.b, e.c-1, e.currWidth+3)));
            } else {
                currMin = Math.min(currMin, 1+recur(new Entry(e.a, e.b, e.c-1, 3)));
            }
        }

        cache.put(e, currMin);
        return currMin;
    }

    static class Entry {
        int a;
        int b;
        int c;
        int currWidth = 0;

        public Entry(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public Entry(int a, int b, int c, int currWidth) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.currWidth = currWidth;
        }

        @Override
        public String toString() {
            return "Entry{" +
            "a=" + a +
            ", b=" + b +
            ", c=" + c +
            ", currWidth=" + currWidth +
            '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (a != entry.a) return false;
            if (b != entry.b) return false;
            if (c != entry.c) return false;
            return currWidth == entry.currWidth;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            result = 31 * result + c;
            result = 31 * result + currWidth;
            return result;
        }
    }
}
