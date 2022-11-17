import java.util.*;
import java.io.*;


public class CowDanceShow {
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner((new FileReader("cowdance.in")));
        n = sc.nextInt();
        int t = sc.nextInt();

        int[] times = new int[n];
        for (int i=0; i<n; i++) {
            times[i] = sc.nextInt();
        }
        int min = 0;
        int max = n;

        while (min < max) {
            int mid = (min+max)/2;
            if (works(mid, times, t)) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("cowdance.out"));
        pw.println(min);
        pw.close();
    }

    public static boolean works(int k, int[] times, int t) {
        int minVal = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            if (q.size() == k) {
                minVal = q.poll();
            }
            if (minVal + times[i] > t) {
                return false;
            }
            q.add(minVal + times[i]);
        }
        return true;
    }
}
