import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Data {
    int numLaps;
    long totalTime;
    Data(int numLaps, long totalTime) {
        this.numLaps =numLaps;
        this.totalTime = totalTime;
    }
    Data() {
        this.numLaps = 0;
        this.totalTime = 0;
    }
}

public class kaploeb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        HashMap<Long, Data> map = new HashMap<>();
        int l = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        long s = Integer.parseInt(tokens[2]);

        for (int i = 0; i < l; i++) {
            tokens = br.readLine().split(" ");
            long sNo = Integer.parseInt(tokens[0]);
            String[] time = tokens[1].split("\\.");
            int lapTime = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            Data current = map.getOrDefault(sNo, new Data());
            current.numLaps++;
            current.totalTime += lapTime;
            map.put(sNo, current);
        }
        map.entrySet().stream()
                .filter(e -> e.getValue().numLaps == k)
                .sorted(
                        Comparator.comparingLong((Map.Entry<Long, Data> e) -> e.getValue().totalTime)
                                .thenComparingLong(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey()));
    }
}
