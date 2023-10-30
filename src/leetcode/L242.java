package leetcode;

// Valid Anagram
public class L242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] a = new int[26]; // distribution of a
        char[] chars = s.toCharArray();
        for(char c : chars) {
            a[c-'a']++;
        }
        chars = t.toCharArray();
        for(char c : chars) {
            a[c-'a']--;
        }
        for(int i : a) {
            if (i != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
