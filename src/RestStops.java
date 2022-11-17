import java.io.*;
import java.util.*;


public class RestStops {
    static int l;
    static int n;
    static int f;
    static int b;
    static RP[] rp;
    static boolean[] isMax;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("reststops.in"));
        l = sc.nextInt();
        n = sc.nextInt();
        f = sc.nextInt();
        b = sc.nextInt();

        rp = new RP[n];
        isMax = new boolean[n];

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int c = sc.nextInt();
            rp[i] = new RP(x, c);
        }

        // test case _3__3_2 1__
        int currMax = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (rp[i].c > currMax) {
                isMax[i] = true;
                currMax = rp[i].c;
            }
        }

        long res = 0;
        long tf = 0;
        long tb = 0;
        long prevx = 0;
        for (int i = 0; i < n; i++) {
            if (!isMax[i]) continue;
            tf += (rp[i].x - prevx) * (f);
            tb += (rp[i].x - prevx) * (b);
            res += (tf - tb) * (rp[i].c);
            tb = tf;
            prevx = rp[i].x;
        }

        PrintWriter pw = new PrintWriter(new FileWriter("reststops.out"));
        pw.println(res);
        pw.close();
    }

    static class RP {
        int x;
        int c;
        public RP(int x, int c) {
            this.x = x;
            this.c = c;
        }
    }
}