import java.io.*;
import java.util.*;


public class ClosestCowWins {
    static int k;
    static int m;
    static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        k = sc.nextInt();
        m = sc.nextInt();
        n = sc.nextInt();

        Patch[] patches = new Patch[k];
        for (int i=0; i<k; i++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            patches[i] = new Patch(p, t);
        }

        int[] cows = new int[m];
        for (int i=0; i<m; i++) {
            int p = sc.nextInt();
            cows[i] = p;
        }
        long res = 0;

    }

    static class Patch {
        public int p;
        public int t;
        public Patch(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }
}
