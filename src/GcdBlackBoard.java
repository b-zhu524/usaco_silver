import java.io.*;
import java.util.*;


public class GcdBlackBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] boardNumbers = new int[n];
        for (int i=0; i<n; i++) {
            boardNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int currGCD = 0;
        
    }
}
