import java.io.*;
import java.util.*;


public class Alchemy2 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] stock = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i=0; i<n; i++) stock[i] = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(in.readLine());
        int [][] recipes = new int[n+1][];

        for (int i=0; i<k; i++) {
            StringTokenizer stt = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(stt.nextToken())-1;
            int m = Integer.parseInt(stt.nextToken());
            recipes[l] = new int[m];

            for (int j=0; j<recipes[l].length; j++) {
                recipes[l][j] = Integer.parseInt(stt.nextToken());
            }
        }

        int res = solve(n, stock, recipes);
        System.out.println(res);
    }

    public static int solve(int n, int[] stock, int[][] recipes) {
        int ans = 0;

        while (canMake(n-1, stock, recipes)) {
            ans ++;
        }
        return ans;
    }

    private static boolean canMake(int target, int[] stock, int[][] recipes) {
        if (stock[target] > 0) {
            stock[target]--;
            return true;
        }

        if (recipes[target] == null) {

            return false;
        }
        for (int chem : recipes[target]) {
            if (!canMake(chem, stock, recipes)) {
                return false;
            }
        }
        return true;
    }
}
