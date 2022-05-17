import java.util.*;
import java.io.*;


public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] blocks = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) blocks[i] = Integer.parseInt(st.nextToken());

        int res = 0;
        int max_block = 0;
        for (int i=0; i<n; i++) {
            if (max_block <= blocks[i]) {
                res ++;
                max_block = blocks[i];
            }
        }

        System.out.println(res);
    }
}
