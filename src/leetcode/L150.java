package leetcode;

import java.util.Stack;

public class L150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String t : tokens) {
            switch (t) {
                case "+" -> s.push(s.pop() + s.pop());
                case "-" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b - a);
                }
                case "*" -> s.push(s.pop() * s.pop());
                case "/" -> {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b / a);
                }
                default -> s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        L150 s = new L150();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
