import java.io.*;
import java.util.*;

public class CountingHaybales {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("haybales");
        int n = io.nextInt();
        int q = io.nextInt();
        int[] bales = new int[n];

        PrintWriter out = new PrintWriter("haybales.out");


        for (int i = 0; i < n; i++) bales[i] = io.nextInt();
        Arrays.sort(bales);

        for (int i = 0; i < q; i++) {
            int start = io.nextInt();
            int end = io.nextInt();

            // leftmost
            int l = Arrays.binarySearch(bales, start);
            if (l < 0) l = Math.abs(l + 1);

            // rightmost
            int r = Arrays.binarySearch(bales, end);
            if (r < 0) r = Math.abs(r+2);
            out.println(r - l + 1);
        }
        out.close();
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