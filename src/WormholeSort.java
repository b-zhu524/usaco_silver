import java.io.*;
import java.util.*;


public class WormholeSort {
    static int n;
    static int m;
    static ArrayList<Neighbor>[] neighbors;
    static boolean[] visited;
    static int[] cows;
    static boolean alrSorted;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt();
        m = sc.nextInt();

        cows = new int[n];
        neighbors = new ArrayList[n];
        visited = new boolean[n];

        for (int i=0; i<n; i++) {
            neighbors[i] = new ArrayList<>();

            int num = sc.nextInt();
            cows[i] = num-1;
        }

        int maxWidth = 0;

        for (int i=0; i<m; i++) {
            int c1 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            int w = sc.nextInt();
            neighbors[c1].add(new Neighbor(c2, w));
            neighbors[c2].add(new Neighbor(c1, w));
            maxWidth = Math.max(maxWidth, w);
        }


        int lo = 0;
        int hi = maxWidth+1;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (sortable(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (alrSorted) {
            System.out.println(-1);
        } else {
            System.out.println(lo);
        }
    }

    static void dfs(int c, int w) {
        if (neighbors[c].isEmpty()) {
            return;
        }
        for (int i=0; i<n; i++) {
            for (Neighbor neighbor : neighbors[i]) {
                if (neighbor.w < w) continue;
                visited[c] = true;
                cnt++;
                dfs(neighbor.c, w);
            }
        }
    }

    static boolean sortable(int w) {
        int[] labels = new int[n];
        int label = 1;
        while (cnt < n-1) {
            for (int i=0; i<n; i++) {
                if(!visited[i]) dfs(0, w);
                label++;
                labels[i] = label;
            }
        }

        for (int i=0; i<n; i++) {
            if (labels[cows[i]] != labels[i]) {
                return false;
            }
            if (i==n-1) alrSorted=true;
        }

        return true;
    }

    static class Neighbor {
        int c;
        int w;
        public Neighbor(int c, int w) {
            this.c = c;
            this.w = w;
        }
    }
}
