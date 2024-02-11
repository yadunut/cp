import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int start;
    int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " " + end;
    }
}

public class speedrun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int G = sc.nextInt();
        int N = sc.nextInt();
        ArrayList<Task> tasks = new ArrayList<>(N);
        while (N-- > 0) {
            tasks.add(new Task(sc.nextInt(), sc.nextInt()));
        }
        tasks.sort(Comparator.comparingInt(s -> s.end));
//        System.out.println(tasks)

        int prev = 0;
        int count = 1;
        for(int i  = 1; i < tasks.size(); i++) {
            Task current = tasks.get(i);
            Task previous = tasks.get(prev);
//            System.out.print("Current: " + current + " previous: " + previous);
            if (current.start >= previous.end) {
//                System.out.print(" incr\n");
                count++;
                prev = i;
            }
//            else System.out.print(" skip\n");

        }
        if (count >= G) System.out.println("YES");
        else System.out.println("NO");
    }
}
