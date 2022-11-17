import java.io.*;
import java.util.*;


public class Lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        int n = Integer.parseInt(br.readLine());
        Event[] events = new Event[n*2];
        int[][] shifts = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            shifts[i][0] = s;
            shifts[i][1] = e;
            events[i*2] = new Event(s, 1);
            events[i*2+1] = new Event(e, -1);
        }

        Arrays.sort(events);

        int numCovered = 0;
        int[] sums = new int[n*2+1];
        int[] ones = new int[n*2+1];

        for (int i=1; i<n*2+1; i++) {
            int v1 = sums[i-1] + events[i-1].type;
            sums[i] = v1;
            int v2 = 0;
            if (v1 == 1) {
                v2 = v1;
            }
            ones[i] = ones[i-1] + v2;
        }

        int s=events[0].type;
        for (int i=1; i<n*2; i++) {
            if (ones[i] != 0 && s != 0) {
                numCovered += events[i].time - events[i-1].time;
            }
            s += events[i].type;
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];

            Event S = new Event(start, 1);
            Event E = new Event(end, -1);
            int sIdx = Arrays.binarySearch(events, S);
            int eIdx = Arrays.binarySearch(events, E);
            int v = numCovered - (ones[eIdx + 1] - ones[sIdx]);
            res = Math.max(res, v);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("lifeguards.out"));
        pw.println(res);
        pw.close();
    }

    static class Event implements Comparable<Event> {
        int time;
        int type;

        public Event(int time, int type) {
            this.time = time;
            this.type = type;
        }

        public int compareTo(Event other) {
            if (this.time > other.time) {
                return 1;
            } else if (this.time < other.time) {
                return -1;
            } else {
                if (this.type == other.type) {
                    return 0;
                } else if (this.type == 1) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }
}
