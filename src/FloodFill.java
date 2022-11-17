import java.io.*;
import java.util.*;


public class FloodFill {
    static int[][] visited;
    static int[][] nums;
    static int n;
    static int x;
    static int y;
    static int[] i1 = {1, -1, -1, 1};
    static int[] i2 = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();


        visited = new int[n][n];
        nums = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int p = sc.nextInt();
                nums[i][j] = p;
            }
        }
        floodfill(x, y);

        int res = 0;
        if (nums[x][y] == 0) {
            res++;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                res += visited[i][j];
            }
        }
        System.out.println(res);
    }


    public static void floodfill(int x, int y) {
        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = 1;

        while (!q.isEmpty()) {
            Point p = q.getFirst();
            q.removeFirst();

            for (int i=0; i<4; i++) {
                int nx = i1[i] + p.x;
                int ny = i2[i] + p.y;

                if (ny < n && ny >= 0 && nx < n && nx >= 0 && visited[nx][ny] != 1 && nums[nx][ny] != 1) {
                    q.add(new Point(nx, ny));
                    visited[nx][ny] = 1;
                }

            }
        }
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
