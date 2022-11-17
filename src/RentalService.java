import java.io.*;
import java.util.*;


public class RentalService {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("rental.in"));
        StringTokenizer l1 = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());
        int r = Integer.parseInt(l1.nextToken());

        Integer[] cows = new Integer[n];
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(in.readLine());
            cows[i] = c;
        }

        Store[] stores = new Store[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int q = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            stores[i] = new Store(q, p);
        }

        Integer[] rentals = new Integer[r];

        for (int i = 0; i < r; i++) {
            int p = Integer.parseInt(in.readLine());
            rentals[i] = p;
        }

        Arrays.sort(cows, new CompBackwards());
        Arrays.sort(stores);
        Arrays.sort(rentals, new CompBackwards());

        // find the best balance between milk and rentals

        // stores
        long[] milkProfits = new long[n + 1];

        int j = 0;
        for (int i = 0; i < n; i++) {
            milkProfits[i + 1] = milkProfits[i];
            while (j < m && cows[i] > 0) {
                int gallons = Math.min(cows[i], stores[j].max);
                milkProfits[i + 1] += (long) gallons * stores[j].pay;
                cows[i] -= gallons;
                stores[j].max -= gallons;
                if (stores[j].max == 0) {
                    j++;
                }
            }
        }

        long[] rentProfits = new long[n+1];
        int i = n-1;
        j = 0;
        while (i >= 0 && j < r) {
            rentProfits[i] = rentProfits[i+1];
            rentProfits[i] += rentals[j];
            j++;
            i--;
        }

        long res = 0;
        for (int k=1; k<n+1; k++) {
            res = Math.max(res, rentProfits[k] + milkProfits[k]);
        }

        PrintWriter pw = new PrintWriter(new FileWriter("rental.out"));
        pw.println(res);
        pw.close();
    }

    static class CompBackwards implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    }

    static class Store implements Comparable<Store> {
        int max;
        int pay;

        public Store(int m, int p) {
            this.max = m;
            this.pay = p;
        }

        public int compareTo(Store other) {
            return other.pay - this.pay;
        }
    }
}
