import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {
    public static int solve(int n, String cows) {
        int r = 0;
        int og = 0;
        int eg = 0;


        for (int i=0; i<n/2; i++){;
            char oddCow = cows.charAt(i*2);
            char evenCow = cows.charAt(i*2+1);

            if (oddCow == 'G' && evenCow == 'G') {
                og += 1;
                eg += 1;
            } else if (oddCow == 'G' && evenCow == 'H') {
                if (eg > og) {
                    r += 1;
                    int temp = eg;
                    eg = og;
                    og = temp;
                } else {
                    og += 1;
                }
            } else if (oddCow == 'H' && evenCow == 'G') {
                if (og > eg) {
                    r += 1;
                    int temp = eg;
                    eg = og;
                    og = temp;
                } else {
                    eg += 1;
                }
            }
        }
        if (og > eg) {
            r += 1;
            int temp = eg;
            eg = og;
            og = temp;
        }
        return r;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine().trim();
            int n = Integer.parseInt(line);
            String cows = br.readLine().trim();

            int res = solve(n, cows);
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}