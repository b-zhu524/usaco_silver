import java.util.*;
import java.io.*;


public class SnowBootsFieldTable {
    static int n;
    static int b;
    static int[] tiles;
    static int[] sd;
    static int[] dist;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("snowboots.in"));
        n = sc.nextInt();
        b = sc.nextInt();

        for (int i = 0; i < n; i++) {
            tiles[i] = sc.nextInt();
        }

        for (int i = 0; i < b; i++) {
            sd[i] = sc.nextInt();
            dist[i] = sc.nextInt();
        }

        tiles = new int[n];
        sd = new int[b];
        dist = new int[b];
        visited = new boolean[b][n];
    }

    static int solve() {
        for (int boot = 0; boot < b; boot++) {
            for (int tile = 0; tile < n; tile++) {
                if (tiles[tile] > sd[b]) {
                    visited[boot][tile] = false;
                    continue;
                }

                if (tile == 0 && boot == 0) {
                    visited[0][0] = true;
                }

                if (tile == n - 1 && visited[tile][b]) {
                    return b;
                }
            }
        }

        return 1;
    }
}
