import java.io.*;
import java.util.*;


public class Boxers {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] weights = new int[n];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i=0; i<n; i++) weights[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weights);


        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }
}
