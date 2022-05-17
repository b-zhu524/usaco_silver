import java.io.*;
import java.util.*;



public class ForestQueries {
    static int n;
    static int q;
    static int[][] arr;
    static int[][] pfx;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        n = io.nextInt();
        q = io.nextInt();

        pfx = new int[n+1][n+1];
        arr = new int[n+1][n+1];

        for (int i=0; i<n; i++) {
            String line = io.next();
            for (int j=0; j<n; j++) {
                if (line.charAt(j) == '*') {
                    arr[i+1][j+1] ++;
                }
            }
        }

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<n+1; j++) {
                pfx[i][j] = arr[i][j] + pfx[i][j-1] + pfx[i-1][j] - pfx[i-1][j-1];
            }
        }

        for (int i=0; i<q; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            int d = io.nextInt();
            io.println(pfx[c][d] - pfx[a-1][d] - pfx[c][b-1] + pfx[a-1][b-1]);
        }
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


