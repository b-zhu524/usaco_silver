import java.io.*;
import java.util.*;


public class BirthdayParty {
    static boolean[][] adj;
    static boolean[] visited;
    static int p;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if (p == 0 && c == 0) {
                break;
            }

            boolean connected = true;
            adj = new boolean[p][p];
            Edge[] edges = new Edge[c];
            for (int i=0; i<c; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                adj[a][b] = true;
                adj[b][a] = true;
                edges[i] = new Edge(a, b);
            }

            for (Edge e : edges) {
                adj[e.a][e.b] = false;
                adj[e.b][e.a] = false;
                visited = new boolean[p];
                dfs(0);
                for (int i=0; i<p; i++) {
                    if (!visited[i]) {
                        connected = false;
                        break;
                    }
                }
                adj[e.a][e.b] = true;
                adj[e.b][e.a] = true;
            }

            if (connected) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }


    public static void dfs(int pos) {
        visited[pos] = true;
        for (int friendPos = 0; friendPos < p; friendPos++) {
            if (adj[pos][friendPos] && !visited[friendPos]) {
                dfs(friendPos);
            }
        }
    }

    static class Edge {
        public int a;
        public int b;
        public Edge (int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
