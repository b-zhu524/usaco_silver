import java.io.*;
import java.util.*;


public class RentalService {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("rental.in"));
        PrintWriter out = new PrintWriter(new FileWriter("rental.out"));
        StringTokenizer l1 = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int m = Integer.parseInt(l1.nextToken());
        int r = Integer.parseInt(l1.nextToken());

        // milk produced
        int[] milkProduced = new int[n];
        for (int i=0; i<n; i++) milkProduced[i] = Integer.parseInt(in.readLine());

        // store buys milk
        Shop[] stores = new Shop[m];
        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            stores[i] = new Shop(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(stores);

        // rent a cow
        int[] rentPrice = new int[r];
        for (int i=0; i<r; i++) rentPrice[i] = Integer.parseInt(in.readLine());
    }

    public static void sort(int[] l) {
        Arrays.sort(l);

    }
    static class Shop implements Comparable<Shop> {
        public int quantity, price;
        public Shop(int a, int b) {
            quantity=a;
            price=b;
        }
        public int compareTo(Shop s) {
            return s.price - price;
        }
    }
}
