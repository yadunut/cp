package ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RadixSort {

    // offset multiple of 65536
    static int[] radixSortOffset(int arr[], int offset) {
        ArrayList<Integer> buckets[] = new ArrayList[65536];
        IntStream.range(0, 65536).forEach(i -> buckets[i] = new ArrayList<>());
        Arrays.stream(arr).forEach(i -> buckets[(i >> offset) & 65535].add(i));
        return IntStream.range(0, 6553).flatMap(i -> buckets[i].stream().mapToInt(a -> a)).toArray();
    }

    static int[] radixsort(int arr[]) {
        // Find the maximum number to know number of digits
        int arr1[] = radixSortOffset(arr, 0);
        System.out.println(Arrays.toString(arr1));
        int arr2[] = radixSortOffset(arr1, 16);
        System.out.println(Arrays.toString(arr2));
        return arr2;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1000000, 65536, 6123123, 123123123, 1, 2, 3, 4};

        RadixSort.radixsort(arr);
    }
}
