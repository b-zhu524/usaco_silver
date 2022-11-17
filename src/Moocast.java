import java.io.*;
import java.util.*;


public class Moocast {
    static Cow[] cows;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        int n = Integer.parseInt(br.readLine());
        cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x, y, p, i);
        }

        int res = 0;
        for (int i=0; i<n; i++) {
            boolean[] visited = new boolean[n];
            res = Math.max(res, dfs(n, cows[i], visited));
        }
        PrintWriter pw = new PrintWriter(new FileWriter("moocast.out"));
        pw.println(res);
        pw.close();
    }

    private static int dfs(int n, Cow cow, boolean[] visited) {
        if (visited[cow.id]) {
            // already visited -> go to next one
            return 0;
        }
        visited[cow.id] = true;

        int cowsTransmitted = 0;
        for (int i=0; i<n; i++) {
            if ((Math.abs(cows[i].x - cow.x))*(Math.abs(cows[i].x - cow.x)) + Math.abs(cows[i].y - cow.y)*
                    Math.abs(cows[i].y - cow.y) <= cow.p*cow.p) {
                cowsTransmitted += dfs(n, cows[i], visited);
            }
        }
        return ++cowsTransmitted;
    }

    static class Cow {
        public int x;
        public int y;
        public int p;
        public int id;

        public Cow (int x, int y, int p, int id) {
            this.x = x;
            this.y = y;
            this.p = p;
            this.id = id;
        }
    }
}
