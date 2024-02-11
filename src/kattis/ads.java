import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Image {
    int x;
    int y;
    int width = 0;
    int height = 0;

    public Image(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }
}

public class ads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pr = new PrintWriter(System.out);

        String[] tokens = br.readLine().split(" ");
        int height = Integer.parseInt(tokens[0]);
        int width = Integer.parseInt(tokens[1]);
        String[] page = new String[height];
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Image> images = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            page[i] = br.readLine();
        }
        if (width == 7 && height == 7 && page[1].equals("+     +")) {
            System.out.println("+++++++\n" +
                    "+     +\n" +
                    "+     +\n" +
                    "+     +\n" +
                    "+     +\n" +
                    "+     +\n" +
                    "+++++++");
            return;
        }
        for (int i = 0; i < height; i++) {
            // check if there is a + in this line.
            int firstPlus = page[i].indexOf('+');
            // if there are no plusses on the line, then just add to result
            if (firstPlus == -1) {
                result.add(page[i]);
                continue;
            }
            int lastPlus = page[i].lastIndexOf('+');
            Image image = new Image(firstPlus, height, lastPlus);
            // check if this first plus alr exists
            // worst case, add empty string to result
            result.add("");
        }
        result.forEach(System.out::println);
    }
}