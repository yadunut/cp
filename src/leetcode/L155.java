package leetcode;

import java.util.Stack;

// Min Stack
public class L155 {
    class MinStack {
        Stack<Integer> s;
        Stack<Integer> min;

        public MinStack() {
            this.s = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(int val) {
            s.push(val);
            if (min.size() == 0 || min.peek() >= val) min.push(val);
        }

        public void pop() {
            if (s.peek().equals(min.peek())) min.pop();
            s.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
