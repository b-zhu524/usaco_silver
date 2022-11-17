import java.io.*;
import java.util.*;

public class Lucky {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        String[] res = new String[t];
        for (int i=0; i<t; i++) {
            String s = br.readLine();
            if (Integer.parseInt(String.valueOf(s.charAt(0))) + Integer.parseInt(String.valueOf(s.charAt(1))) + Integer.parseInt(String.valueOf(s.charAt(2))) == Integer.parseInt(String.valueOf(s.charAt(3))) + Integer.parseInt(String.valueOf(s.charAt(4))) + Integer.parseInt(String.valueOf(s.charAt(5)))) {
                res[i] = "YES";
            } else {
                res[i] = "NO";
            }
        }

        for (int i=0; i<t; i++) {
            System.out.println(res[i]);
        }
    }
}
