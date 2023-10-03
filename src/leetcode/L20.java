package leetcode;

import java.util.Stack;

public class L20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size() == 0) return false;
                    if (stack.peek()!= '(') return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.size() == 0) return false;
                    if (stack.peek()!= '{') return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.size() == 0) return false;
                    if (stack.peek()!= '[') return false;
                    stack.pop();
                    break;
                default:
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
