import java.io.*;
import java.util.*;


public class ZTest {
    static int[] bus;
    static int n;
    static int m;
    static int c;

    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("convention");
        n = io.nextInt();
        m = io.nextInt();
        c = io.nextInt();

        bus = new int[n];
        for (int i=0; i<n; i++) bus[i] = io.nextInt();
        int low = 0;
        int high = 1000000001;
        Arrays.sort(bus);

        int res = binSearch(low, high);
        FileWriter fw = new FileWriter("convention.out");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(res);
        pw.close();
    }

    public static int binSearch(int low, int high) {
        if (low==high) return low;
        if (low+1==high) {
            if (works(low)) return low;
            return high;
        }

        int mid = (low+high)/2;
        if (works(mid)) {
            return binSearch(low, mid);
        } else {
            return binSearch(mid+1, high);
        }
    }

    public static boolean works(int maxTime)  {
        int cars = 1;
        int firstCow = bus[0];
        int firstIdx = 0;

        for (int i=1; i<n; i++) {
            if (i-firstIdx+1 > c || bus[i] - firstCow > maxTime) {
                firstIdx = i;
                firstCow = bus[i];
                cars++;
            }
        }
        return (cars <= m);
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
