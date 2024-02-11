import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Flight {
    int start;
    int end;
    int capacity;

    public Flight(int start, int end, int capacity) {
        this.start = start;
        this.end = end;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "start=" + start +
                ", end=" + end +
                ", capacity=" + capacity +
                '}';
    }
}

public class traveltheskies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAirports = sc.nextInt();
        int days = sc.nextInt();
        int numFlights = sc.nextInt();
        HashMap<Integer, ArrayList<Flight>> flights = new HashMap<>();
        for (int i = 0; i < days; i++) flights.put(i + 1, new ArrayList<>());
        for (int i = 0; i < numFlights; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int day = sc.nextInt();
            int capacity = sc.nextInt();
            flights.get(day).add(new Flight(start, end, capacity));
        }
        // map of day, airport and customers
        HashMap<Integer, HashMap<Integer, Integer>> arrivals = new HashMap<>();
        for (int i = 0; i < days; i++) arrivals.put(i + 1, new HashMap<>());
        for (int i = 0; i < numAirports * days; i++) {
            int airport = sc.nextInt();
            int day = sc.nextInt();
            int customers = sc.nextInt();
            arrivals.get(day).put(airport, customers);
        }
//        System.out.println(flights);
//        System.out.println(arrivals);


        //  array of people at each airport at the moment
        HashMap<Integer, Integer> people = new HashMap<>();
        // go through each day
        for (int i = 1; i <= days; i++) {
            ArrayList<Flight> todayFlights = flights.get(i);
            for (Map.Entry<Integer, Integer> entry : arrivals.get(i).entrySet()) {
                people.put(entry.getKey(), people.getOrDefault(entry.getKey(), 0) + entry.getValue());
           }
//            System.out.println(people);
            // remove people leaving country
            for(Flight f: todayFlights) {
                people.put(f.start, people.get(f.start) - f.capacity);
                if (people.get(f.start) < 0) {
                    System.out.println("suboptimal");
                    return;
                }
            }
            for(Flight f: todayFlights) {
                people.put(f.end, people.get(f.end) + f.capacity);
            }
        }
        System.out.println("optimal");
    }
}
