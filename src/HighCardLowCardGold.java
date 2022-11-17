import java.io.*;
import java.util.*;
import java.util.Arrays;

public class HighCardLowCardGold {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cardgame");

        int n = io.nextInt();
        HashSet<Integer> used = new HashSet<>();

        int[] ecards = new int[n];
        for (int i=0; i<n; i++) {
            int val = io.nextInt();
            ecards[i] = val;
            used.add(val);
        }

        int[] bcards = new int[n];
        int idx=0;
        for (int j=1; j<(2*n)+1; j++) {
            if (!(used.contains(j))) {
                bcards[idx] = j;
                idx++;
            }
        }

        int points = 0;

        // half 1 (high card wins)
        Integer[] eh1 = new Integer[n/2];
        Integer[] bh1 = new Integer[n/2];
        for (int i=0; i<n/2; i++) {
            bh1[i] = bcards[(n/2)+i];
            eh1[i] = ecards[i];
        }

        Arrays.sort(eh1);
        Arrays.sort(bh1);

        int bessieIndex = 0;
        int elsieIndex = 0;
        while(bessieIndex < (n/2) && elsieIndex < (n/2)) {
            if(bh1[bessieIndex] > eh1[elsieIndex]) {
                points++;
                bessieIndex++;
                elsieIndex++;
            }
            else {
                bessieIndex++;
            }
        }

        // half 2 (low card wins)
        Integer[] eh2 = new Integer[n/2];
        Integer[] bh2 = new Integer[n/2];
        for (int i=0; i<n/2; i++) {
            eh2[i] = ecards[(n/2)+i];
            bh2[i] = bcards[i];
        }
        Arrays.sort(eh2, new Backwards());
        Arrays.sort(bh2, new Backwards());

        bessieIndex = 0;
        elsieIndex = 0;
        while(bessieIndex < (n/2) && elsieIndex < (n/2)) {
            if (bh2[bessieIndex] < eh2[elsieIndex]) {
                points++;
                bessieIndex++;
                elsieIndex++;
            } else {
                bessieIndex++;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("cardgame.out"));
        pw.println(points);
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


    static class Backwards implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }
}
