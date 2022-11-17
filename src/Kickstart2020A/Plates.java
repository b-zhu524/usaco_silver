package Kickstart2020A;

import java.io.*;
import java.util.StringTokenizer;

public class Plates {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();

        int[] res = new int[t];
        for (int i=0; i<t; i++) {
            int n = io.nextInt();
            int k = io.nextInt();
            int p = io.nextInt();

            int[][] stacks = new int[n][k];
            for (int j=0; j<n; j++) {
                for (int kk=0; kk<k; k++) {
                    stacks[j][kk] = io.nextInt();
                }
            }


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
