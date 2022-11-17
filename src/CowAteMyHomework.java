import java.io.*;
import java.util.*;


public class CowAteMyHomework {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("homework.in"));
        int n = Integer.parseInt(br.readLine());

        int[] scores = new int[n];
        int[] lowestScores = new int[n];
        int[] ps = new int[n];

        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int s = Integer.parseInt(st.nextToken());
            scores[i] = s;
            totalSum += s;
            ps[i] = totalSum;
        }

        for (int i=n-1; i>=0; i--) {
            int s = scores[i];
            if (i==n-1 || s < scores[i+1]) {
                lowestScores[i] = s;
            } else {
                lowestScores[i] = lowestScores[i+1];
            }
        }

        float bestScore = 0;
        for (int i=0; i<n-1; i++) {
            int s = ps[i];
            int score = (totalSum - s - lowestScores[i+i]) / (n-1-i);
            bestScore = Math.max(score, bestScore);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("homework.out"));
        for (int i=0; i<n-1; i++) {
            int s = ps[i];
            int score = (totalSum - s - lowestScores[i+1]) / (n-1-i);
            if (score==bestScore) {
                pw.println(i+1);
            }
        }
        pw.close();
    }
}
