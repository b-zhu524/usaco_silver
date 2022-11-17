package Kickstart2020A;


import java.io.*;
import java.util.*;
public class Allocation {
    static int b;

    public static void main(String[] args) {
        Kattio io = new Kattio();
        int t = io.nextInt();

        int[] res = new int[t];
        for (int i=0; i<t; i++) {
            int n = io.nextInt();
            b = io.nextInt();

            int[] houses = new int[n];
            for (int j=0; j<n; j++) houses[j] = io.nextInt();
            Arrays.sort(houses);

            for (int x: houses) {
                if (b-x >= 0) {
                    b-=x;
                    res[i]++;
                } else break;
            }
        }

        for (int i=0; i<t; i++) {
            System.out.print("Case #"+Integer.toString(i+1)+":" + " " + Integer.toString(res[i]));
            if (i<t-1) System.out.println();
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
