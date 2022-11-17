import java.io.*;
import java.util.StringTokenizer;

public class EqualCandies {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();
        int[] res = new int[t];

        for (int i=0; i<t; i++) {
            int n = io.nextInt();
            int[] a = new int[n];
            int minVal = Integer.MAX_VALUE;
            for (int j=0; j<n; j++) {
                int v = io.nextInt();
                a[j] = v;
                minVal = Math.min(minVal, v);
            }

            for (int j=0; j<n; j++) {
                res[i] += a[j] - minVal;
            }
        }

        for (int i=0; i<t; i++) {
            System.out.println(res[i]);
        }
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
