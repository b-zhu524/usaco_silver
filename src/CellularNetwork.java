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

        long res = 0;
        int j = 0;

        for (int i=0; i<n; i++) {
            while (j+1 < m && Math.abs(cities[i] - cells[j]) >= Math.abs(cities[i]-cells[j+1])) j++;
            res = Math.max(res, Math.abs(cities[i] - cells[j]));
        }

        System.out.println(res);
    }
}

