import java.io.*;
import java.util.*;


public class CoveredPointsCount {
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());

		Event[] events = new Event[n*2];

		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			events[i*2] = new Event(l, EventType.Start);
			events[i*2+1] = new Event(r, EventType.End);
		}

		Arrays.sort(events);
		long[] res = solve(n, events);
		for (int i=1; i<=n; i++) {
			System.out.print(res[i]);
			System.out.print(" ");
		}
    }

	static long[] solve(int n, Event[] events) {
		long[] res = new long[n+1];

		int cnt = 0;
		int i = 0;
		n *= 2;
		long prevX = events[0].x;

		while (i < n) {
			// points in between
			long currX = events[i].x;

			long points = currX - prevX - 1;
			if (points > 0) {
				res[cnt] += points;
			}

			// edge points
			while (i<n && events[i].x == currX && events[i].type == EventType.Start) {
				i++;
				cnt++;
			}

			res[cnt] += 1;

			while (i<n && events[i].x == currX) {
				i++;
				cnt--;
			}
			prevX = currX;
		}

		return res;
	}

	static class Event implements Comparable<Event> {
		long x;
		EventType type;

		public Event(long x, EventType type) {
			this.x = x;
			this.type = type;
		}

		@Override
		public int compareTo(Event o) {
			if (this.x == o.x) {
				if (this.type == o.type) {
					return 0;
				} else if (this.type == EventType.Start) {
					return -1;
				} else {
					return 1;
				}
			}
			return Long.compare(this.x, o.x);
		}
	}
	enum EventType {
		Start,
		End
	}
}
