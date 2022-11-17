import java.io.*;
import java.util.*;


public class CellularNetwork2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());
        int[] cities = new int[n];
        int[] towers = new int[m];

        StringTokenizer l2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int city = Integer.parseInt(l2.nextToken());
            cities[i] = city;
        }

        StringTokenizer l3 = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int tower = Integer.parseInt(l3.nextToken());
            towers[i] = tower;
        }

        int r = 0;
        int j = 0;
        for (int i=0; i<n; i++) {
            while (j+1 < m && Math.abs(towers[j+1] - cities[i]) <= Math.abs(towers[j] - cities[i])) {
                j++;
            }

            r = Math.max(r, Math.abs(towers[j] - cities[i]));
        }

        System.out.println(r);
    }
}
