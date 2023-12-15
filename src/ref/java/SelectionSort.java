package ref;

public class SelectionSort {
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int smallest = i;
            for (int j = i; j < input.length; j++) {
                if (input[smallest] > input[j]) smallest = j;
            }
            swap(input, i, smallest);
        }
    }
}