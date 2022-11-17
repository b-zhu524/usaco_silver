import java.io.*;
import java.util.*;


public class RestaurantCustomers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Event[] customers = new Event[n * 2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			customers[i * 2] = new Event(s, 1);
			customers[i * 2 + 1] = new Event(e, -1);
		}

		Arrays.sort(customers);

		int sum = 0;
		int res = 0;
		for (Event e : customers) {
			sum += e.type;
			res = Math.max(res, sum);
		}

		System.out.println(res);
	}
	static class Event implements Comparable<Event> {
		int time;
		int type;

		public Event(int time, int type) {
			this.time = time;
			this.type = type;
		}

		public int compareTo(Event o) {
			return this.time - o.time;
		}
	}
}
