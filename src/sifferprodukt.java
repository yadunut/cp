import java.util.Arrays;
import java.util.Scanner;

public class sifferprodukt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        while(result.length() > 1) {
            result = Arrays.stream(result.split("")).map(Integer::parseInt).filter(i -> i > 0).reduce((a, b) -> a * b).orElseThrow().toString();
        }
        System.out.println(result);
    }
}
