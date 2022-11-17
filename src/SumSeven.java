import java.util.*;
import java.io.*;


public class SumSeven {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("div7");
        int n = io.nextInt();

        long[] pfx = new long[n+1];
        pfx[0] = 0;

        long sum = 0;
        for (int i=1; i<=n; i++) {
            int v = io.nextInt();
            sum += v;
            pfx[i] = (sum)%7;
        }


        int res = 0;
        for (int find=0; find<7; find++) {
            int i = 1;
            while (i<n+1 && pfx[i]!=find) {
                i++;
            }
            int j=n;
            while(j>0 && j>i && pfx[j]!=find) {
                j--;
            }
            res = Math.max(res, j-i);
        }

        FileWriter file = new FileWriter("div7.out");
        PrintWriter pw = new PrintWriter(file);
        pw.println(res);
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
