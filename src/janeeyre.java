import java.util.PriorityQueue;
import java.util.Scanner;

class Book implements Comparable<Book> {
    String name;
    int pages;

    Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return name.equals(book.name);
    }

    @Override
    public String toString() {
        return name + "(" + pages + ")";
    }
}

class Pair implements Comparable<Pair> {
    int time;
    Book b;

    public Pair(int time, String name, int pages) {
        this.time = time;
        this.b = new Book(name, pages);
    }

    @Override
    public String toString() {
        return b.toString();
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.time, o.time);
    }
}

public class janeeyre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        PriorityQueue<Book> pq = new PriorityQueue<>();
        PriorityQueue<Pair> future = new PriorityQueue<>();
        int initialBooks = sc.nextInt(), additionalBooks = sc.nextInt();
        Book janeEyre = new Book("Jane Eyre", sc.nextInt());
        sc.nextLine();
        pq.add(janeEyre);

        // add the inital Books to the list
        for (int i = 0; i < initialBooks; i++) {
            String[] line = sc.nextLine().split("\"");
            if (line[1].strip().compareTo("Jane Eyre") > 0) continue;
            pq.add(new Book(line[1].strip(), Integer.parseInt(line[2].strip())));
        }

        for (int i = 0; i < additionalBooks; i++) {
            String[] line = sc.nextLine().split("\"");
            if (line[1].strip().compareTo("Jane Eyre") > 0) continue;
            future.add(new Pair(Integer.parseInt(line[0].strip()), line[1].strip(), Integer.parseInt(line[2].strip())));
        }

        Book current = pq.poll();
        int minutesTaken = current.pages;

        while (!current.equals(janeEyre)) {
            // if new books came while she was reading the current book, add to the pile
            // so check if the current time is more than the time that the new books came in
            Pair fBook = future.peek();
            while (fBook != null && minutesTaken >= fBook.time) {
//                System.out.printf("time: %d, book in time: %d, book: %s\n", minutesTaken, fBook.time, fBook.b);
                pq.add(future.poll().b);
                fBook = future.peek();
            }
            // take out the latest book add to the reading time
            current = pq.poll();
            minutesTaken += current.pages;
        }
        System.out.println(minutesTaken);
    }
}
