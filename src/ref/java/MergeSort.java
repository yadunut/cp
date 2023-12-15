package ref;

public class MergeSort {
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int N = high - low + 1;
        int[] result = new int[N];
        int left = low, right = mid + 1, rIdx = 0;

        while (left <= mid && right <= high)
            result[rIdx++] = (arr[left] <= arr[right]) ? arr[left++] : arr[right++];
        while (left <= mid) result[rIdx++] = arr[left++];
        while (right <= high) result[rIdx++] = arr[right++];
        System.arraycopy(result, 0, arr, low, N);
    }


    static void sort(int[] input, int low, int high) {
        if(low < high) {
            int mid = (low+high) / 2;
            sort(input, low, mid);
            sort(input, mid+1, high);
            merge(input, low, mid, high);
        }
    }
}
