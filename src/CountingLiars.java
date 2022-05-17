import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;


public class CountingLiars {
    static int against_g(int n, ArrayList<Integer> llist, int g_val) {
        int cnt = 0;
        int len = llist.size();
        for (int cow : llist) {
            if (cow == -1) {
                continue;
            }
            if (cow < g_val) {
                cnt++;
            }
        }
        return cnt;
    }

    static int against_l(int n, ArrayList<Integer> glist, int l_val) {
        int cnt = 0;
        int len = glist.size();
        for (int i=len-1; i>-1; i--) {
            int cow = glist.get(i);
            if (cow == -1) {
                continue;
            }
            if (cow > l_val) {
                cnt ++;
            }
        }
        return cnt;
    }

    static int solve(int n, ArrayList<Integer> llist, ArrayList<Integer> glist) {
        int liars = 0;
        int i = 0; // llist idx
        int j = glist.size()-1; // glist idx
        while ((i < llist.size()) && (j < glist.size()) && llist.get(i) < glist.get(j)) {
            int al = against_l(n, glist, llist.get(i));
            int ag = against_g(n, llist, glist.get(j));
            if (ag > al && ag > 0) {
                glist.set(j, -1);
                j --;
                liars ++;
            } else if (al > 0){
                llist.set(i, -1);
                i ++;
                liars ++;
            }
        }
        return liars;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        int n = Integer.parseInt(line);
        ArrayList<Integer> glist = new ArrayList<>();
        ArrayList<Integer> llist = new ArrayList<>();
        for (int i=0; i<n; i++) {
            String[] tmp = in.readLine().trim().split(" ");
            if (tmp[0].equals("G")) {
                glist.add(Integer.parseInt(tmp[1]));
            } else {
                llist.add(Integer.parseInt(tmp[1]));
            }
        }
        Collections.sort(glist);
        Collections.sort(llist);
        int res = solve(n, llist, glist);
        System.out.println(res);
    }
}