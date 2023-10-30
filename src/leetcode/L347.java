package leetcode;

import java.util.*;

// 347. Top K Frequent Elements
public class L347 {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Number, Number> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0).intValue() + 1);
    }

    PriorityQueue<Map.Entry<Number, Number>> pq = new PriorityQueue<>(
    (a,b) -> b.getValue().intValue() - a.getValue().intValue()

    );

    for (Map.Entry<Number, Number> entry : map.entrySet()) {
      pq.add(entry);
    }
    int[] result = new int[k];
    for (int i = 0; i < k; i++)
    result[i] = pq.remove().getKey().intValue();
    return result;
  }
}
