import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bear {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        str.split(" ");
        char ls = str.charAt(0);
        char bs = str.charAt(1);

        int l = Integer.parseInt(String.valueOf(ls));
        int b = Integer.parseInt(String.valueOf(bs));
        System.out.print(l);
        System.out.print(b);

        int ans = 0;
        while (true) {
            if (l < b) {
                break;
            }
            l *= 3;
            b *= 2;
        }
        System.out.print(ans);
    }
}
