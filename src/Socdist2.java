import java.io.*;
import java.util.*;


public class Socdist2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("socdist2.in"));
        int n = Integer.parseInt(in.readLine());

        int[][] cows = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows, (a, b) -> a[0]-b[0]);
        System.out.println(Arrays.toString(cows));

    }
}