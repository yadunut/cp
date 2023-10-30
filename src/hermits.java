
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hermits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numStreets = Integer.parseInt(br.readLine());
        int[] people = new int[numStreets];
        int[] streetVal = new int[numStreets];
        String[] peopleStr = br.readLine().split(" ");
        for (int i = 0; i < numStreets; i++) {
            int numPeople = Integer.parseInt(peopleStr[i]);
            people[i] = numPeople;
            streetVal[i] = numPeople;
        }

        int crossings = Integer.parseInt(br.readLine());
        for (int i = 0; i < crossings; i++) {
            String[] tokens = br.readLine().split(" ");
            int main = Integer.parseInt(tokens[0]) - 1;
            int cross = Integer.parseInt(tokens[1]) - 1;
            streetVal[main] += people[cross];
            streetVal[cross] += people[main];
        }
        int currMin = Integer.MAX_VALUE, ans = -1;
        for(int i = 0; i < numStreets;i++) {
            if (currMin > streetVal[i]) {
                currMin = streetVal[i];
                ans = i;
            }
        }
        System.out.println(ans+1);
    }
}
