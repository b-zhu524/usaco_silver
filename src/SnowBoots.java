import java.io.*;
import java.util.*;


public class SnowBoots {
    static int N;
    static int B;
    static int[] tiles;
    static Boot[] boots;
    static boolean[][] visited;

    static int res = 10000;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("snowboots.in"));
        N = sc.nextInt();
        B = sc.nextInt();
        visited = new boolean[N][B];

        tiles = new int[N];
        for (int i=0; i<N; i++) {
            tiles[i] = sc.nextInt();
        }

        boots = new Boot[B];
        for (int i=0; i<B; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            boots[i] = new Boot(s, d);
        }


        dfs(0, 0);
        PrintWriter pw = new PrintWriter(new FileWriter("snowboots.out"));
        pw.println(res);
        pw.close();

    }

    public static void dfs(int i, int b) {
        if (visited[i][b]) {
            return;
        }
        visited[i][b] = true;

        if (i == N-1) {
            res = Math.min(res, b);
            return;
        }

        for (int j=i+1; j<N && j-i <= boots[b].d; j++) {
            if (boots[b].s >= tiles[j]) {
                dfs(j, b);
            }
        }

        for (int b2=b+1; b2<B; b2++) {
            if (boots[b2].s >= tiles[i]) {
                dfs(i, b2);
            }
        }
    }

    static class Boot {
        public int s;   // depth
        public int d;   // dist
        public Boot(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }
}
