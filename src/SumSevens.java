import java.io.*;
import java.util.*;


public class SumSevens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];

        int s = 0;
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            p[i] = num+s;
            s += num;
        }
        System.out.println(Arrays.toString(p));

        int res = 0;
        for (int i=n-1; i>0; i--) {
            int num = Integer.parseInt(br.readLine());
            if (num % 7 == 0) {
                res = i+1;
                break;
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        pw.println(res);
    }
}
