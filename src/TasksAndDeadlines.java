import java.io.*;
import java.util.*;


public class TasksAndDeadlines {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] tasks = new int[n][2];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i][0] = Integer.parseInt(st.nextToken());
            tasks[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(n, tasks));
    }

    private static int solve(int n, int[][] tasks) {
        Arrays.sort(tasks, new Comp());
        int score = 0;
        int time = 0;
        for (int i=0; i<n; i++) {
            int t = tasks[i][0];
            int s = tasks[i][1];
            time += t;
            score += (s-time);
        }
        return score;
    }
}

class Comp implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (!(a[0] == b[0])) {
            return a[0] - b[0];
        } else {
            return a[1] - b[1];
        }
    }
}