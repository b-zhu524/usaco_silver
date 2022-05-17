import java.io.*;
import java.util.*;


public class LightsOff {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[][] rooms = new int[n][n];
        int[][][] switches = new int[n][n][2];

        for (int i=0; i<m; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stt.nextToken())-1;
            int y = Integer.parseInt(stt.nextToken())-1;
            int a = Integer.parseInt(stt.nextToken())-1;
            int b = Integer.parseInt(stt.nextToken())-1;
            switches[x][y][0] = a;
            switches[x][y][1] = b;
        }

    }

    private static int solve(int n, int m, int[][] rooms, HashMap<int[][], int[][]> switches) {
        return 1;
    }

    private static int flick() {
        return 1;
    }
}
