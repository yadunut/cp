package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Time Based Key-Value Store
public class L981 {
    class TimeMap {
        HashMap<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!map.containsKey(key)) map.put(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> res = map.get(key);
            if (res == null) return "";
            Map.Entry<Integer, String> entry = res.floorEntry(timestamp);
            if (entry == null) return "";
            return entry.getValue();
        }
    }

}
