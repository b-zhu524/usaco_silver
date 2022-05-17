import java.io.*;
import java.util.*;

public class PaintingTheBarn {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paintbarn");
        int n = io.nextInt();
        int k = io.nextInt();
        int[][] arr = new int[1001][1001];

        for (int i=0; i<n; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            int d = io.nextInt();
            arr[a][b] ++;
            arr[a][d] --;
            arr[c][b] --;
            arr[c][d] ++;
        }

        int res = 0;
        for (int i=0; i<1000; i++) {
            for (int j=0; j<1000; j++) {
                if (!(i==0)) arr[i][j] += arr[i-1][j];
                if (!(j==0)) arr[i][j] += arr[i][j-1];
                if (!(i==0) && !(j==0)) arr[i][j] -= arr[i-1][j-1];
                if (arr[i][j] == k) res ++;
            }
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
