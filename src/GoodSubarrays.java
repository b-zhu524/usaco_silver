import java.io.*;
import java.util.*;


public class GoodSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] ns = new int[t];
        int[][] arrs = new int[t][];


        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            String r = br.readLine();
            String[] temp = r.split("");
            int[] a = new int[temp.length];
            for (int j=0; j < temp.length; j++) a[j] = Integer.parseInt(temp[j]);
            ns[i] = n;
            arrs[i] = a;
        }

        for (int i=0; i<t; i++) {
            System.out.println(solve(ns[i], arrs[i]));
        }
    }
    private static int solve(int n, int[] a) {
        int[] p = new int[n+1];
        p[0] = 0;
        for (int i=0; i<n; i++) {
            p[i+1] = p[i] + a[i];
        }

        int ans = 0;
        HashMap<Integer, Integer> ls = new HashMap<>();
        ls.put(0, 1);

        for (int r=0; r<n; r++) {
            if (ls.containsKey(p[r+1]-r-1)) {
                ans += ls.get(p[r+1]-r-1);
                ls.put(p[r+1]-r-1, ls.get(p[r+1]-r-1) + 1);
            } else {
                ls.put(p[r+1]-r-1, 1);
            }
        }
        return ans;
    }
}
