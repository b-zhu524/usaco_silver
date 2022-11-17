import java.io.*;
import java.util.*;


public class ThreeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int x = Integer.parseInt(l1.nextToken());

        int[] a = new int[n];
        HashMap<Integer, Integer> idx = new HashMap<>();
        StringTokenizer l2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int v = Integer.parseInt(l2.nextToken());
            a[i] = v;
            idx.put(v, i);
        }

        int[] res = new int[3];

        for (int i=0; i<n; i++) {
            boolean flag = false;

            for (int j=0; j<n; j++) {
                if (i==j) continue;

                int s = a[i] + a[j];
                if (idx.containsKey(x-s)) {
                    int k = idx.get(x-s);
                    if (i==k || j==k) continue;
                    res[0] = i+1;
                    res[1] = j+1;
                    res[2] = k+1;
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        if (res[0]==0 && res[1]==0) {
            System.out.println("IMPOSSIBLE");
        } else {
            Arrays.sort(res);
            for (int i = 0; i < 3; i++) {
                System.out.print(res[i]);
                if (i != 2) System.out.print(" ");
                else System.out.println();
            }
        }
    }
}
