import java.io.*;
import java.util.*;


public class BuildingTeams {
    static HashMap<Integer, ArrayList<Integer>> g = new HashMap<>();
    static int[] colors;
    static int n;
    static int m;
    static boolean[] visited;
    static boolean IMP = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            
        }
    }

    public static void dfs(int node, int color) {
        visited[node] = true;
        colors[node] = color;

    }
}
