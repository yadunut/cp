// B first 25 points are "TRIVIAL"

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class subarrays {

    // static long beauty(int l, int r) {
    // long acc = 0;
    // for (int i = l; i <= r; i++) {
    // acc += arr[i];
    // }
    // // System.out.println("acc = " + acc);
    // acc = acc - (long)
    // return acc;
    // }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[] arr = new int[N];
        int[] cum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        cum[0] = arr[0];
        for (int i = 1; i < N; i++)
            cum[i] = arr[i] + cum[i - 1];

//        System.out.println("arr = " + Arrays.toString(arr));
//        System.out.println("cum = " + Arrays.toString(cum));


        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int beauty;
                if (i == 0) beauty = cum[j] - (j - i + 1) * K;
                else beauty = cum[j] - cum[i-1] - (j - i + 1) * K;
                if (beauty == B) {
                    System.out.printf("%d %d\n", i, j);
                    return;
                }
            }
        }
        System.out.println("-1");
    }
}
