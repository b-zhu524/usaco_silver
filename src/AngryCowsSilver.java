import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;


public class AngryCowsSilver {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("angry");
        int n = io.nextInt();
        int k = io.nextInt();
        int[] bales = new int[n];
        for (int i = 0; i < n; i++) bales[i] = io.nextInt();
        Arrays.sort(bales);

        int min = 0;
        int max = 50000000;

        while (min != max && max > min) {
            int mid = (min+max)/2;

            int used = 0;
            int last = 0;
            while (last < n) {
                used++;
                int curr = last + 1;
                while (curr < n && bales[curr] - bales[last] <= 2*mid) {
                    curr ++;
                }
                last = curr;
            }
            if (used <= k) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("angry.out"));
        pw.println(min);
        pw.close();
    }


    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
