package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 1845. Seat Reservation Manager
class L1845 {

    class SeatManager {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        public SeatManager(int n) {
            for(int i = 1; i <=n; i++) q.add(i);
        }

        public int reserve() {
            return q.poll();
        }

        public void unreserve(int seatNumber) {
            q.add(seatNumber);
        }
    }

}
