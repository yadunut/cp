package leetcode;

import java.util.Stack;

// Implement Queue using Stacks
public class L232 {
    class MyQueue {
        Stack<Integer> a;
        Stack<Integer> b;

        public MyQueue() {
            this.a = new Stack<>();
            this.b = new Stack<>();
        }

        public void push(int x) {
            this.b.push(x);
        }

        public int pop() {
            if (this.a.empty()) while (!b.empty()) a.push(b.pop());
            return a.pop();
        }

        public int peek() {
            if (this.a.empty()) while (!b.empty()) a.push(b.pop());
            return a.peek();

        }

        public boolean empty() {
            return a.empty() && b.empty();
        }
    }

}

