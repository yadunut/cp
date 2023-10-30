import java.util.*;



public class janeeyre {
    static class Book implements Comparable<Book> {
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

    static class Pair implements Comparable<Pair> {
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
            return Integer.compare(o.time, this.time);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Book> pile = new PriorityQueue<>();
        Stack<Pair> future = new Stack<>();
        int initialBooks = sc.nextInt(), additionalBooks = sc.nextInt();
        Book janeEyre = new Book("Jane Eyre", sc.nextInt());
        sc.nextLine();
        pile.add(janeEyre);

        // add the inital Books to the list
        for (int i = 0; i < initialBooks; i++) {
            String[] line = sc.nextLine().split("\"");
            if (line[1].compareTo("Jane Eyre") > 0) continue;
            pile.add(new Book(line[1], Integer.parseInt(line[2].strip())));
        }

        for (int i = 0; i < additionalBooks; i++) {
            String[] line = sc.nextLine().split("\"");
            if (line[1].compareTo("Jane Eyre") > 0) continue;
            future.add(new Pair(Integer.parseInt(line[0].strip()), line[1], Integer.parseInt(line[2].strip())));
        }
        Collections.sort(future);

        Book current = null;
        long minutesTaken = 0;

        while (current == null || !current.equals(janeEyre)) {

            // take out the latest book add to the reading time
            current = pile.poll();
            minutesTaken += current.pages;
            // if new books came while she was reading the current book, add to the pile
            // so check if the current time is more than the time that the new books came in
            while (!future.empty() && minutesTaken >= future.peek().time) {
                pile.add(future.pop().b);
            }
        }
        System.out.println(minutesTaken);
    }
}
