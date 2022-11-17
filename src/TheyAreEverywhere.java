import java.io.*;
import java.util.*;

public class TheyAreEverywhere {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String flats = in.readLine();

        HashSet<Character> types = new HashSet<>();
        for (int i=0; i<n; i++){
            char c = flats.charAt(i);
            types.add(c);
        }

        int t = types.size();

        int res = Integer.MAX_VALUE;
        int left = 0;

        HashMap<Character, Integer> found = new HashMap<>();
        for (int right=0; right<n; right++) {
            char curr = flats.charAt(right);
            found.put(curr, found.getOrDefault(curr, 0)+1);

            while (left+1 <= right && found.getOrDefault(flats.charAt(left), 0) > 1) {
                found.put(flats.charAt(left), found.getOrDefault(flats.charAt(left), 0)-1);
                left++;
            }
            if (found.size() == t) {
                res = Math.min(res, right-left+1);
            }
        }

        System.out.println(res);
    }
}
