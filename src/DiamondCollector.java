import java.io.*;
import java.util.*;


public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int k = Integer.parseInt(l1.nextToken());
        int[] diamonds = new int[n];

        for (int i = 0; i < n; i++) diamonds[i] = Integer.parseInt(br.readLine());
        Arrays.sort(diamonds);

        int i = 0;
        int j = 0;
        int res = 0;
        while (j < n) {
            if (i == j) {
                if (i == n-1) {
                    break;
                }
                j++;
            }
            if (diamonds[j] - diamonds[i] <= k) {
                j++;
            } else {
                res = Math.max(res, j-i);
                i=j;
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("diamond.out"));
        pw.println(res);
        pw.close();
    }
}
