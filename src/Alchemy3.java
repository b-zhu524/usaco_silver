import java.io.*;
import java.util.*;


public class Alchemy3 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] have = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0; i<n; i++) have[i] = Integer.parseInt(st.nextToken());
        int[][] recipes = new int[n][];

        int k = Integer.parseInt(in.readLine());
        for(int i=0; i<k; i++) {
            StringTokenizer sst = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(sst.nextToken());
            int m = Integer.parseInt(sst.nextToken());

            recipes[l-1] = new int[m];
            for (int j=0; j<m; j++) recipes[l-1][j] = Integer.parseInt(sst.nextToken());
        }

        int ans = solve(n, have, recipes);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        out.println(ans);
        out.close();
    }

    private static int solve(int n, int[] have, int[][] recipes) {
//        System.out.println(n-1);
//        System.out.println(Arrays.toString(have));
//        for (int i=0; i<n; i++) System.out.println(Arrays.toString(recipes[i]));

        int ans = 0;
        while (canCook(n-1, have, recipes)) ans ++;
        return ans;
    }

    private static boolean canCook(int target, int[] have, int[][] recipes) {
        if (have[target] > 0) {
            have[target]--;
            return true;
        }
        if (recipes[target] == null) {
            return false;
        }

        for (int metal : recipes[target]) {
            if (!canCook(metal-1, have, recipes)) {
                return false;
            }
        }
        return true;
    }
}
