import java.io.*;
import java.util.*;

public class Revegetation {
    static boolean impossible = false;
    static int[] colors;
    static List<Integer> same[];
    static List<Integer> diff[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("revegetate.in"));
        StringTokenizer l1 = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());

        same = new ArrayList[n+1];
        diff = new ArrayList[n+1];
        for (int i=0; i<n+1; i++) {
            same[i] = new ArrayList<>();
            diff[i] = new ArrayList<>();
        }

        colors = new int[n+1]; // {1, -1}

        // each connected component has two possibilities (one normal and one flipped)
        // all connected components are mutually exclusive
        // thus there are 2^c possibilities of farming seeds (where c is the number of connected components)

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            Character s = st.nextToken().charAt(0);
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            if (s == 'S') {
                same[p1].add(p2);
                same[p2].add(p1);
            } else {
                diff[p1].add(p2);
                diff[p2].add(p1);
            }
        }

        int connectedComponents = 0;
        for (int i=1; i<n+1; i++) {
            if (colors[i] == 0) {
                dfs(i, 1);
                connectedComponents++;
            }
        }


        PrintWriter pw = new PrintWriter(new FileWriter("revegetate.out"));
        if (impossible) {
            pw.println("0");
        } else {
            pw.print("1");
            for (int i=0; i<connectedComponents; i++) {
                pw.print("0");
            }
            pw.println();
        }
        pw.close();
    }

    public static void dfs(int node, int color) {
        if (impossible) return;

        colors[node] = color;

        for (Integer neighbor : same[node]) {
            if (colors[neighbor] == 0) {
                // if 0, then fill
                // if different, then impossible
                // if same, then it's a cycle (found component already)

                dfs(neighbor, color);
            } else if (colors[neighbor] != color) {
                impossible = true;
            }
        }

        for (Integer neighbor : diff[node]) {
            if (colors[neighbor] == 0) {
                dfs(neighbor, color*(-1));
            } else if (colors[neighbor] == color) {
                impossible = true;
            }
        }
    }
}
