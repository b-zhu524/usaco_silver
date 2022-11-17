import java.io.*;
import java.util.*;


public class CrossCountrySkiing {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int n;
    static int m;
    static int[][] points = new int[m][n];
    static int[][] wp = new int[m][n];
    static ArrayList<Point> wpLst = new ArrayList<>();
    static boolean[][] visited = new boolean[m][n];
    static int startY;
    static int startX;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("ccski.in"));
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int p = sc.nextInt();
                points[i][j] = p;
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                wp[i][j] = sc.nextInt();
                wpLst.add(new Point(i, j));
            }
        }

        int low = 0;
        int high = 1000000000;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canReach(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("ccski.out"));
        pw.println(low);
        pw.close();
    }

    public static boolean canReach(int d) {
        floodfill(d);
        for (Point p : wpLst) {
            int y = p.y;
            int x = p.x;
            if (!visited[y][x]) {
                return false;
            }
        }
        visited = new boolean[m][n];
        return true;
    }

    public static void floodfill(int d) {
        LinkedList<Point> q = new LinkedList<>();

        q.add(new Point(startY, startX));
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            Point p = q.getFirst();
            q.removeFirst();

            for (int i=0; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if (ny < m && ny >= 0 && nx < n && nx >= 0) {
                    if (Math.abs(points[p.y][p.x] - points[ny][nx]) > d) {
                        break;
                    }
                    q.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static class Point {
        public int x;
        public int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
