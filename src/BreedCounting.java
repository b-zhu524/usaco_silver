import java.util.*;
import java.io.*;


public class BreedCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("bcount.in"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] line = new int[n];
        for (int i=0; i<n; i++) line[i] = Integer.parseInt(in.readLine());
        int[][] intervals = new int[q][2];
        for (int i=0; i<q; i++) {
            StringTokenizer sst = new StringTokenizer(in.readLine());
            int n1 = Integer.parseInt(sst.nextToken());
            int n2 = Integer.parseInt(sst.nextToken());
            intervals[i][0] = n1;
            intervals[i][1] = n2;
        }
        for (int i=0; i<q; i++) {
            System.out.println(solve(n, line, intervals[i]));
        }
    }
    private static String solve(int n, int[] line, int[] intervals) {
        int a = 0;
        int b = 0;
        int c = 0;
        return "";
    }
}
