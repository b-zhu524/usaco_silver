import java.io.*;
import java.util.*;


public class RectangularPasture {
    static int[][] sums;

    static int getSum(int fromX, int toX, int fromY, int toY) {
        return sums[toX][toY] - sums[fromX - 1][toY] - sums[toX][fromY - 1] + sums[fromX - 1][fromY - 1];
    }

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt();
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];

        for (int i = 0; i < n; i++) {
            xs[i] = io.nextInt();
            ys[i] = io.nextInt();
            cows[i] = i;
        }

        Arrays.sort(cows, Comparator.comparingInt(i -> xs[i]));
        for (int x = 1; x < n+1; x++) xs[cows[x-1]] = x;

        Arrays.sort(cows, Comparator.comparingInt(i -> ys[i]));
        for (int y = 1; y < n+1; y++) ys[cows[y-1]] = y;

        sums = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) sums[xs[i]][ys[i]]++;

        for (int x = 0; x < n+1; x++) {
            for (int y = 0; y < n+1; y++) {
                if (x > 0) sums[x][y] += sums[x - 1][y];
                if (y > 0) sums[x][y] += sums[x][y - 1];
                if (y > 0 && x > 0) sums[x][y] -= sums[x - 1][y - 1];
            }
        }

        long ans = n+1;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (xs[i]==1 && xs[j]==3) {
                    System.out.println(getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), 1, Math.min(ys[j], ys[i])));
                    System.out.println(getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), Math.max(ys[j], ys[i]), n));
                }
                ans += getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), 1, Math.min(ys[j], ys[i])) *
                getSum(Math.min(xs[j], xs[i]), Math.max(xs[j], xs[i]), Math.max(ys[j], ys[i]), n);
            }
        }
        System.out.println(ans);
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