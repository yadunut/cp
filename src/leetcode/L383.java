package leetcode;

public class L383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] rDist = new int[26];
        for(int i = 0; i < ransomNote.length(); i++) {
            rDist[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++) {
            rDist[magazine.charAt(i) - 'a']--;
        }

        for(int i = 0; i < rDist.length; i++) {
            if (rDist[i] > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
