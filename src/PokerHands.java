import java.util.*;
import java.io.*;


public class PokerHands {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("poker.in"));
        int n = sc.nextInt();

        int[] a = new int[n+2];
        for (int i = 1; i < n+1; i++) {
            a[i] = sc.nextInt();
        }
        a[n+1] = 0;
        a[0] = 0;


        float res = 0;
        for (int i=1; i<n+2; i++) {
            res += Math.abs(a[i]-a[i-1]);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("poker.out"));
        pw.println(Math.round(Math.ceil(res/2)));
        pw.close();
    }
}