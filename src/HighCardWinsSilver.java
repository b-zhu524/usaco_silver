import java.io.*;
import java.util.*;


public class HighCardWinsSilver {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("highcard");
        int n = io.nextInt();

        HashSet<Integer> used = new HashSet<>();
        int[] ecards = new int[n];

        for (int i=0; i<n; i++) {
            int val = io.nextInt();
            ecards[i] = val;
            used.add(val);
        }

        int[] bcards = new int[n];
        int idx = 0;
        for (int j=1; j<(n*2)+1; j++) {
            if (!(used.contains(j))) {
                bcards[idx] = j;
                idx++;
            }
        }
        Arrays.sort(ecards);

        int bessieIndex = 0;
        int elsieIndex = 0;
        int res = 0;
        while(bessieIndex < n && elsieIndex < n) {
            if(bcards[bessieIndex] > ecards[elsieIndex]) {
                res++;
                bessieIndex++;
                elsieIndex++;
            }
            else {
                bessieIndex++;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("highcard.out"));
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
