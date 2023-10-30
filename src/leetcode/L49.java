package leetcode;

import java.util.*;

// Group Anagrams
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> m = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.put(c, map.get(c) != null ? map.get(c) + 1 : 1);
            }
            if (!m.containsKey(map)) {
                m.put(map, new ArrayList<>());
            }
            m.get(map).add(str);
        }
        return new ArrayList<>(m.values());
    }
}
