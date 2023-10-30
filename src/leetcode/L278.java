package leetcode;

class VersionControl {
    boolean[] arr = new boolean[]{
            true,
            true,
    };
    boolean isBadVersion(int version) {
        return arr[version-1];
    }
}

class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, mid;
        while (l < r) {
            mid = l + (r-l) / 2;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

// First Bad Version

public class L278 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstBadVersion(2));
    }

}
