package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class L3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        // map of character and its index
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            while (set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        L3 s = new L3();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
        System.out.println(s.lengthOfLongestSubstring("dvdf"));
    }
}
