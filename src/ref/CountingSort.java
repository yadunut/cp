package ref;

import java.util.*;
import java.util.stream.IntStream;

public class CountingSort {
    Map<Integer, Integer> counter;

    public CountingSort() {
        counter = new TreeMap<>();
    }

    void insert(int a) {
        counter.compute(a, (k, freq) -> freq == null ? 1 : freq + 1);
    }

    int[] ordered() {
        return counter.entrySet().stream().flatMapToInt(e -> IntStream.range(0, e.getValue()).map(x -> e.getKey())).toArray();
    }

    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        cs.insert(1);
        cs.insert(1);
        cs.insert(1);
        cs.insert(5);
        cs.insert(5);
        cs.insert(3);
        cs.insert(3);
        cs.insert(3);
        System.out.println(Arrays.toString(cs.ordered()));
    }
}
