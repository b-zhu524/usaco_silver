import java.io.*;
import java.util.*;


public class FencePlanning {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());

        boolean[][] adj = new boolean[n+1][n+1];
        int[] x = new int[n+1];
        int[] y = new int[n+1];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xVal = Integer.parseInt(st.nextToken());
            int yVal = Integer.parseInt(st.nextToken());
            x[i] = xVal;
            y[i] = yVal;
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = true;
            adj[b][a] = true;
        }
        int res = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int v = dfs(n, i, visited, adj);
            res = Math.min(v, res);
            System.out.println(v);
        }
    }

    public static int dfs(int n, int pos, boolean[] visited, boolean[][] adj) {
        if (visited[pos]) {
            return 0;
        }

        visited[pos] = true;
        int cnt = 1;

        for (int i=1; i<=n; n++) {
            if (adj[pos][i]) {
                cnt += dfs(n, i, visited, adj);
            }
        }
        return cnt;
    }
}
