import java.io.*;
import java.util.*;


public class BuildGates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        int n = Integer.parseInt(br.readLine());
        String gate = br.readLine();
        int currX = 1002;
        int currY = 1002;
        boolean[][] isFence = new boolean[2005][2005];
        isFence[currX][currY] = true;
        for (int i=0; i<n; i++) {
            System.out.println(currX);
            System.out.println(currY);
            int dirX = 0;
            int dirY = 0;
            if (gate.charAt(i)=='N') {
                dirX = -1;
            } else if (gate.charAt(i)=='S') {
                dirX = 1;
            } else if (gate.charAt(i)=='W') {
                dirY = -1;
            } else {
                dirY = 1;
            }
            for (int cnt=0; cnt<2; cnt++) {
                currX += dirX;
                currY += dirY;
                isFence[currX][currY] = true;
            }
        }

        int res = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        for (int i=0; i<2005; i++) {
            for (int j=0; j<2005; j++) {
                if (isFence[i][j]) {
                    continue;
                }

                res++;
                LinkedList<Point> q = new LinkedList<>();
                q.add(new Point(i, j));
                isFence[i][j] = true;

                // flood fill BFS
                while(!q.isEmpty()) {
                    Point curr = q.removeFirst();
                    for (int k=0; k<4; k++) {
                        int nx = curr.x + dx[k];
                        int ny = curr.y + dy[k];
                        if(nx >= 0 && nx < 2005 && ny >= 0 && ny < 2005 && !isFence[nx][ny]) {
                            isFence[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("gates.out"));
        pw.println(res-1);
        pw.close();
    }

    static class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
