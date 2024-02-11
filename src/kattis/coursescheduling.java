import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class coursescheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); sc.nextLine();
        TreeMap<String, HashSet<String>> courses = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            String[] tokens = sc.nextLine().split(" ");
            if (!courses.containsKey(tokens[2])) courses.put(tokens[2], new HashSet<>());
            courses.get(tokens[2]).add(tokens[0] + tokens[1]);
        }
        courses.forEach((s, k) -> System.out.println(s + " " + k.size()));
    }
}
