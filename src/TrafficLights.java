import java.util.*;
import java.io.*;


public class TrafficLights {
//    public static void main(String[] args) throws IOException {
//        FastIO io = new FastIO();
//        TreeSet<Integer> positions = new TreeSet<>();
//        TreeMap<Integer, Integer> dist = new TreeMap<>();
//
//        int streetLen = io.nextInt();
//        int n = io.nextInt();
//
//        positions.add(0);
//        positions.add(streetLen);
//        dist.put(streetLen, 1);
//
//        int[] lights = new int[n];
//        for (int i=0; i<n; i++) {
//            int x = io.nextInt();
//            lights[i] = x;
//        }
//
//        int[] res = new int[n];
//        for (int i=0; i<n; i++) {
//            int x = lights[i];
//            int prev_up = positions.ceiling(x);
//            int prev_down = positions.floor(x);
//            int prev_dist = prev_up - prev_down;
//
//            dist.put(prev_dist, dist.get(prev_dist)-1);
//            if (dist.get(prev_dist) <= 0) { // log n
//                dist.remove(prev_dist); // log n
//            }
//
//            positions.add(x);
//            int d1 = x - prev_down;
//            int d2 = prev_up - x;
//            dist.put(d1, dist.getOrDefault(d1, 0) + 1); // log n
//            dist.put(d2, dist.getOrDefault(d2, 0) + 1); // log n
//            res[i] = dist.lastKey();
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i=0; i<n; i++) {
//            sb.append(res[i]);
//            sb.append(" ");
//        }
//        System.out.println(sb);
//    }

    public static void main(String[] args) {
        FastIO io = new FastIO();
        int streetLen = io.nextInt();
        int n = io.nextInt();

        TreeSet<Integer> positions = new TreeSet<>();
        positions.add(0);
        positions.add(streetLen);

        int[] lights = new int[n];

        for (int i=0; i<n; i++) {
            int x = io.nextInt();
            lights[i] = x;
            positions.add(x);
        }

        int[] res = new int[n];
        int prev = 0;
        int max = 0;
        for (int p : positions) {
            max = Math.max(max, p-prev);
            prev = p;
        }

        for (int i=n-1; i>0; i--){
            positions.remove(lights[i]);
            int down = positions.lower(lights[i]);

        }

        res[n-1] = max;


    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1<<16];
        private int curChar, numChars;

        // standard input
        public FastIO() { this(System.in,System.out); }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        // file input
        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        // throws InputMismatchException() if previously detected end of file
        private int nextByte() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
        public String next() {
            int c; do { c = nextByte(); } while (c <= ' ');
            StringBuilder res = new StringBuilder();
            do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
            return res.toString();
        }
        public int nextInt() { // nextLong() would be implemented similarly
            int c; do { c = nextByte(); } while (c <= ' ');
            int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10*res+c-'0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}

