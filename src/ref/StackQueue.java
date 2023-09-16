package ref;

import java.util.Stack;

// Queue impl using 2 stacks
public class StackQueue {
    Stack<Integer> a;
    Stack<Integer> b;

    public StackQueue() {
        this.a = new Stack<>();
        this.b = new Stack<>();
    }
    public void push(int x) {
        a.push(x);
    }

    public int pop() {
        if (!b.isEmpty()) return b.pop();
        while (!a.isEmpty()) b.push(a.pop());
        return b.pop();
    }

    public int peek() {
        if (!b.isEmpty()) return b.peek();
        while (!a.isEmpty()) b.push(b.pop());
        return b.peek();

    }

    public boolean empty() {
        return a.isEmpty() && b.empty();
    }



}
