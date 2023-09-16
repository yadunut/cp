import java.util.Scanner;
import java.util.Stack;
// This is not a kattis problem, but a problem proposed in tutorial 3

public class prefixCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> a = new Stack<>();
        Stack<String> b = new Stack<>();
        String[] line = sc.nextLine().split(" ");
        for (String c : line) {
            if (")".equals(c)) {// pop until '(' and push to b
                while (!a.peek().equals("(")) {
                    b.push(a.pop());
                }
                a.pop();
                System.out.println("Previous");
                switch (b.pop()) {
                    case "+": {
                        float result = 0.0F;
                        while (!b.empty()) {
                            System.out.printf("Processing: %s", b.peek());
                            result += Float.parseFloat(b.pop());
                            System.out.printf("result: %f\n", result);

                        }
                        a.push(String.valueOf(result));
                        break;
                    }
                    case "-": {
                        float result = 0.0F;
                        while (!b.empty()) {
                            result -= Float.parseFloat(b.pop());
                        }
                        a.push(String.valueOf(result));
                        break;
                    }
                    case "*": {
                        float result = 1.0F;
                        while (!b.empty()) {
                            result *= Float.parseFloat(b.pop());
                        }
                        a.push(String.valueOf(result));
                        break;
                    }
                    case "/": {
                        float result = 1.0F;
                        while (!b.empty()) {
                            result /= Float.parseFloat(b.pop());
                        }
                        a.push(String.valueOf(result));
                        break;
                    }
                }
                System.out.println(b);
            } else {
                a.push(c);
            }
        }
        a.forEach(System.out::println);
    }
}
