package ref;

public class BubbleSort {
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void sort(int[] input) {
        int N = input.length;

        for(; N > 0; N--) {
            for (int i = 0; i < N-1; i++) {
                if (input[i] > input[i+1]) swap(input, i, i+1);
            }
        }
    }
}

