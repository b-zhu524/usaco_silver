import java.io.*;
import java.util.*;

public class CountingHaybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int q = Integer.parseInt(l1.nextToken());

        int[] locations = new int[n];
        StringTokenizer l2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) locations[i] = Integer.parseInt(l2.nextToken());
        Arrays.sort(locations);

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int bi = Arrays.binarySearch(locations, s);
            if (bi < 0) {
                bi = Math.abs(bi+1);
            }

            int ti = Arrays.binarySearch(locations, e);
            if (ti < 0) {
                ti = Math.abs(ti + 2);
            }
            pw.println(ti-bi+1);
        }
        pw.close();
    }
}
