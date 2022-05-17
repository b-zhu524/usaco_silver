import java.util.*;
import java.io.*;


public class CellularNetwork {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cities = new int[n];
        int[] cells = new int[m];

        StringTokenizer st2 = new StringTokenizer(in.readLine());
        for (int i=0; i<n; i++) cities[i] = Integer.parseInt(st2.nextToken());

        StringTokenizer st3 = new StringTokenizer(in.readLine());
        for (int i=0; i<m; i++) cells[i] = Integer.parseInt(st3.nextToken());

        int res = solve(n, m, cities, cells);
        System.out.println(res);
    }

    private static int solve(int n, int m, int[] cities, int[] cells) {
        return 1;
    }
}

