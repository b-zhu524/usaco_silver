import java.util.*;
import java.io.*;


public class MilkFactory {
    public static void main(String[] args) throws IOException {
        Scanner io = new Scanner(new FileReader("factory.in"));
        int n = io.nextInt();

        HashMap<Integer, Integer> goIn = new HashMap<>();
        HashMap<Integer, Integer> goTo = new HashMap<>();
        for (int i=0; i<n-1; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            goIn.put(b, goIn.getOrDefault(a, 0)+1);
            goTo.put(a, goTo.getOrDefault(b, 0)+1);
        }

        int numSinks = 0;
        int sink = -1;

        for (int i=1; i<n+1; i++) {
            if (goIn.containsKey(i) && !(goTo.containsKey(i))) {
                numSinks++;
                if (numSinks != 1) break;
                sink = i;
            }
        }

        FileWriter file = new FileWriter("factory.out");
        PrintWriter pw = new PrintWriter(file);
        if (numSinks > 1) {
            pw.println(-1);
        } else {
            pw.println(sink);
        }
        pw.close();
    }
}
