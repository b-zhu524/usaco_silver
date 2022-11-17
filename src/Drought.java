import java.io.*;
import java.util.*;


public class Drought {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i=0; i<t; i++) {
            int n = sc.nextInt();
            int[] cows = new int[n];
            for (int j=0; j<n; j++) {
                cows[j] = sc.nextInt();
            }
            System.out.println(solve(n, cows));
        }
    }

    static int solve(int n, int[] cows) {
        int[] d = new int[n-1];
        for (int i=0; i<n-1; i++) {
            d[i] = cows[i+1] - cows[i];
        }

        int res = 0;

        if (d[0] < 0) {
            return -1;
        }

        boolean works = true;
        while (works) {
            works = false;
            for (int i=0; i<n-1; i++) {
                if (d[i] != 0) {

                }
            }
        }
        return res;
    }
}