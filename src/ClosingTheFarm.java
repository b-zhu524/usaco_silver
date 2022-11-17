import java.io.*;
import java.util.*;


public class ClosingTheFarm {
    static boolean[] visited;
    static boolean[] closed;
    static int numVisited;
    static int n;
    static int m;
    static List<Integer> paths[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("closing.in"));
        n = sc.nextInt();
        m = sc.nextInt();

        paths = new ArrayList[n];
        for (int i=0; i<n; i++) {
            paths[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            int b1 = sc.nextInt()-1;
            int b2 = sc.nextInt()-1;
            paths[b1].add(b2);
            paths[b2].add(b1);
        }

        int[] closeOrder = new int[n];
        for (int i=0; i<n; i++) {
            int b = sc.nextInt()-1;
            closeOrder[i] = b;
        }

        visited = new boolean[n];
        closed = new boolean[n];

        int startNode = closeOrder[n-1];

        PrintWriter pw = new PrintWriter(new FileWriter("closing.out"));
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                visited[j] = false;
            }
            numVisited = 0;
            dfs(startNode);
            if (numVisited == n-i) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
            closed[closeOrder[i]] = true;
        }
        pw.close();
    }

    static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        if (closed[node]) {
            return;
        }

        visited[node] = true;
        numVisited++;
        for (int neighbor : paths[node]) {
            dfs(neighbor);
        }
    }
}
