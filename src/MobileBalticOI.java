import java.util.*;
import java.io.*;


public class MobileBalticOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int len = Integer.parseInt(l1.nextToken());
        Point[] points = new Point[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        double lower = 1;
        double upper = 1000000000;
        
        while (upper - lower > 1e-3) {
            double mid = (upper + lower) / 2;
            double currPoint = 0;
            for (int i=0; i<n; i++) { // remove this loop for faster solution
                long x = points[i].x;
                long y = points[i].y;

                double delta = Math.sqrt(mid * mid - y * y);
                double p1 = x - delta;
                double p2 = x + delta;

                if (p1 <= currPoint) {
                    currPoint = Math.max(currPoint, p2);
                }
            }
            if (currPoint < len) {
                lower = mid;
            } else {
                upper = mid;
            }
        }

        String r = String.format("%.6f", lower);
        System.out.println(r);
    }

    static class Point {
        long x;
        long y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
