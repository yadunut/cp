import java.util.Arrays;
import java.util.Scanner;

public class basicprogramming2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int t = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        switch (t) {
            case 1: {
                System.out.println(twoSum(A, 7777) ? "Yes" : "No");
                break;
            }
            case 2: {
                System.out.println(isUnique(A) ? "Unique" : "Contains Duplicates");
                break;
            }
            case 3: {
                containsDupes(A);
                break;
            }
            case 4: {
                medians(A);
                break;
            }
            case 5: {
                inRange(A);
                break;
            }
        }
    }

    private static void inRange(int[] arr) {
        Arrays.stream(arr).filter(a -> a >= 100 && a <= 999).forEachOrdered(v -> System.out.printf("%d ", v));
    }

    private static void medians(int[] arr) {
        if (arr.length % 2 == 0) {
            int idx = (arr.length - 1) / 2;
            System.out.println(arr[idx] + " " + arr[idx + 1]);
        } else {
            int idx = (arr.length - 1) / 2;
            System.out.println(arr[idx]);
        }
    }

    private static void containsDupes(int[] arr) {
        int curr = arr[0], count = 0;
        for(int num: arr) {
            if (count == 0) {
                curr = num;
                count = 1;
            } else if (curr == num) count++;
            else count--;
        }

        if (count <= 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(curr);
    }

    private static boolean isUnique(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                return false;
        }
        return true;
    }

    private static boolean twoSum(int[] arr, int t) {
        int left = 0, right = arr.length - 1;
        while (left != right) {
            int res = arr[left] + arr[right];
            if (res == t) {
                return true;
            }
            if (res > t) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

}
