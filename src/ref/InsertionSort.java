package ref;

public class InsertionSort {
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void sort(int[] arr) {
        // iterate through each element in the array
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            if (tmp > arr[i - 1]) continue;
            int j = i;
            for(; j > 0; j--) {
                arr[j] = arr[j-1];
                if (tmp > arr[j-1]) break;
            }
            arr[j] = tmp;

        }
    }
}
