import java.io.*;
import java.util.*;

public class Convention2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PriorityQueue<Cow> line = new PriorityQueue<>(new SeniorComp());
        int n = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(a, t, i);
            line.add(new Cow(a, t, i));
        }

        int res = 0;
        int curr_time = 0;
        boolean open = true;
        while (!line.isEmpty()) {
            Cow cow = line.poll();
            curr_time = cow.arrival;
        }
        Arrays.sort(cows);
    }

    static class Cow implements Comparable<Cow> {
        int arrival;
        int time;
        int age;
        public Cow(int arrival, int time, int age) {
            this.arrival = arrival;
            this.time = time;
            this.age = age;
        }

        @Override
        public int compareTo(Cow o) {
            return this.time - o.time;
        }
    }

    static class SeniorComp implements Comparator<Cow> {
        public int compare(Cow a, Cow b) {
            return a.age - b.age;
        }
    }
}