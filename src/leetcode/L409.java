package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Longest Palindrome
public class L409 {
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        boolean odd = false;
        int result = 0;
        for (int i : freq.values()) {
            if (i % 2 == 0) result += i;
            else {
                if (!odd) {
                    result += i;
                    odd = true;
                } else {
                    result += i - 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }
}
