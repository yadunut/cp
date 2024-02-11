import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bungeebuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
//        if (N > 100) return;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int right = 1, left = 0, best = 0, lowestPt = arr[left];

        // get the lowest point. If at any point arr[right] is bigger than arr[left], then calculate the best value,
        // and move the left pointer up. This is because we can "forget" all the values before that.
        // If the difference between the right pointer and left pointer is 1, no bungee can be built and incerment right by 1
        // otherwise, just calculate best and increment right by 1
        while (right < arr.length) {
            lowestPt = Math.min(lowestPt, arr[right]);
//            System.out.printf("l(%d), r(%d), lw(%d) b(%d) ", arr[left], arr[right], lowestPt, best);
            if (arr[right] > arr[left]) {
                if (right - left > 1) best = Math.max(Math.min(arr[left], arr[right]) - lowestPt, best);
                lowestPt = Integer.MAX_VALUE;
                left = right;
                right++;
//                System.out.printf("nB(%d), nL(%d), nR(%d)\n", best, arr[left], arr[right]);
                continue;
            }
            if (right - left == 1) {
//                System.out.printf("              nR(%d)\n", arr[right]);
                right++;
                continue;
            }
            best = Math.max(Math.min(arr[left], arr[right]) - lowestPt, best);
            right++;
//            System.out.printf("nB(%d),        nR(%d)\n", best, arr[right]);
        }
        System.out.println(best);
    }
}