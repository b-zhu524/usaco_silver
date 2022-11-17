import java.io.*;
import java.util.*;


public class MountainView {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        int n = Integer.parseInt(br.readLine());
        Mountain[] mountains = new Mountain[n];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            mountains[i] = new Mountain(x-y, x+y);
        }

        Arrays.sort(mountains);

        int curr_max = -1;
        int res = 0;
        for (int i=0; i<n; i++) {
            if (mountains[i].e > curr_max) {
                res++;
                curr_max = mountains[i].e;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));
        pw.println(res);
        pw.close();
    }

    static class Mountain implements Comparable<Mountain> {
        public int s;
        public int e;

        public Mountain(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public int compareTo(Mountain other) {
            if (this.s != other.s) {
                return Integer.compare(this.s, other.s);
            } else {
                return Integer.compare(other.e, this.e);
            }
        }
    }
}
