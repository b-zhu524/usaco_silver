import java.util.*;
import java.io.*;


public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] blocks = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) blocks[i] = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> towers = new TreeMap<>();

        for (int i=0; i<n; i++) {
            if (towers.higherKey(blocks[i]) == null) {
                towers.put(blocks[i], towers.getOrDefault(blocks[i], 0)+1);
            } else {
                int size = towers.higherKey(blocks[i]);
                towers.put(size, towers.get(size)-1);
                if (towers.get(size) == 0) towers.remove(size);

                towers.put(blocks[i], towers.getOrDefault(blocks[i], 0)+1);
            }
        }

        int res = 0;
        for (int i : towers.values()) {
            res += i;
        }
        System.out.println(res);
    }
}
