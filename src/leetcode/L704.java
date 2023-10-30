package leetcode;

// Binary Search
public class L704 {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int pivot = (right + left) / 2;
            if (target == nums[pivot]) return pivot;
            if (target > nums[pivot]) left = pivot+1;
            if (target < nums[pivot]) right = pivot-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
