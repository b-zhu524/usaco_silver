import java.io.*;
import java.util.*;


public class Lifeguards2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        int n = Integer.parseInt(br.readLine());

        Event[] events = new Event[n * 2];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            events[i * 2] = new Event(s, i);
            events[i * 2 + 1] = new Event(e, i);
        }
        Arrays.sort(events);

        int numCovered = 0;
        int[] unique = new int[n];

        int prev = 0;
        for (Event e : events) {
            if (set.size() == 1) {
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    unique[it.next()] += e.time - prev;
                }
            }
            if (!set.isEmpty()) {
                numCovered += e.time - prev;
            }
            if (set.contains(e.shift)) {
                set.remove(e.shift);
            } else {
                set.add(e.shift);
            }
            prev = e.time;
        }

        int res = 0;
        for (int out : unique) {
            res = Math.max(res, numCovered - out);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("lifeguards.out"));
        pw.println(res);
        pw.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        int shift;

        public Event (int time, int shift) {
            this.time = time;
            this.shift = shift;
        }

        public int compareTo (Event other) {
            return this.time - other.time;
        }
    }
}
