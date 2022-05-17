import java.io.*;
import java.util.*;

public class MaxSumPrefArray {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int q = io.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = io.nextInt();


        int[] pfx = new int[n+1];
        pfx[0] = 0;
        for (int i=0; i<q; i++) {
            int l = io.nextInt();
            int r = io.nextInt();
            pfx[l-1]++;
            pfx[r]--;
        }

        for (int i=1; i<n+1; i++) {
            pfx[i] += pfx[i-1];
        }
        Arrays.sort(pfx);
        Arrays.sort(arr);

        long res = 0;
        for (int i=n; i>0; i--) {
            res += (long) arr[i - 1] * pfx[i];
        }
        io.println(res);
        io.close();
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
