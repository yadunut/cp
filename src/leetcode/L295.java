package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

// Find Median from Data Stream
public class L295 {
    static class MedianFinder {
        PriorityQueue<Integer> front;
        PriorityQueue<Integer> back;

        public MedianFinder() {
            this.front = new PriorityQueue<>(Comparator.comparingInt(a -> -a));
            this.back = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        }

        public void addNum(int num) {
            if (this.front.peek() == null) {
                this.front.add(num);
                return;
            }
            if (num > this.front.peek()) this.back.add(num);
            else this.front.add(num);

//            front.forEach(i -> System.out.printf("%d ", i));
//            System.out.print("] back: [");
//            back.forEach(i -> System.out.printf("%d ", i));
//            System.out.print("] \n");

            // balance both halves
            if (back.size() > front.size()) front.add(back.poll());
            if (front.size() > back.size()+1) back.add(front.poll());
        }

        public double findMedian() {
            // if even, then get avg
            if (back.peek() == null) return front.peek();
            if ((front.size() + back.size()) % 2 == 0) {
                return (front.peek() + back.peek()) / 2.0d;
            }
            return front.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder a = new MedianFinder();
        a.addNum(-1);
        System.out.println(a.findMedian());
        a.addNum(-2);
        System.out.println(a.findMedian());
        a.addNum(-3);
        System.out.println(a.findMedian());
        a.addNum(-4);
        System.out.println(a.findMedian());
        a.addNum(-5);
//        System.out.println("front");
//        while(a.front.size() != 0) System.out.println(a.front.poll());
//        System.out.println("back");
//        while(a.back.size() != 0) System.out.println(a.back.poll());
    }
}
