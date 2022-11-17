import java.io.*;
import java.util.*;

public class BerryPicking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("berries.in"));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int k = Integer.parseInt(l1.nextToken());

        int[] trees = new int[n];
        int max = 0;
        StringTokenizer l2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int v = Integer.parseInt(l2.nextToken());
            trees[i] = v;
            max = Integer.max(v, max);
        }

        int res = 0;
        for (int b=1; b<=max; b++) {
            int full = 0;
            int[] leftovers = new int[n];

            for (int i=0; i<n; i++) {
                full += trees[i] / b;
                leftovers[i] = trees[i] % b;
            }

            if (full >= k) {
                res = Math.max(res, (k/2)*b);
            } else if (full >= k/2) {
                int berries = (full-k/2)*b;
                Arrays.sort(leftovers);


                int idx = n-1;
                for (int j=full-k/2; j<k/2; j++) {
                    if (idx < 0) continue;
                    berries += leftovers[idx];
                    idx--;
                }
                res = Math.max(res, berries);
            }
        }

        FileWriter fw = new FileWriter("berries.out");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(res);
        pw.close();
    }
}


