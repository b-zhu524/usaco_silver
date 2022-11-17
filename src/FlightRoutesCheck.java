import java.io.*;
import java.util.*;


public class FlightRoutesCheck {
    static ArrayList<Integer>[] flights;
    static ArrayList<Integer>[] reversed;
    static boolean[] visited1;
    static boolean[] visited2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int n = sc.nextInt();
        int m = sc.nextInt();

        flights = new ArrayList[n+1];
        reversed = new ArrayList[n+1];
        visited1 = new boolean[n+1];
        visited2 = new boolean[n+1];

        for (int i=0; i<n+1; i++) {
            flights[i] = new ArrayList<>();
            reversed[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            flights[a].add(b);
            reversed[b].add(a);
        }

        boolean works = true;
        dfs(1);
        for (int i=1; i<n+1; i++) {
            if (!visited1[i]) {
                works = false;
                System.out.println("NO");
                System.out.print(1);
                System.out.print(" ");
                System.out.println(i);
                break;
            }
        }

        if (works) {
            dfsReversed(1);
            for (int i=1; i<n+1; i++) {
                if (!visited2[i]) {
                    works = false;
                    System.out.println("NO");
                    System.out.print(i);
                    System.out.print(" ");
                    System.out.println(1);
                    break;
                }
            }
        }

        if (works) {
            System.out.println("YES");
        }
    }

    static void dfs(int start) {
        visited1[start] = true;

        for (int x : flights[start]) {
            if (visited1[x]) {
                continue;
            }
            dfs(x);
        }
    }

    static void dfsReversed(int start) {
        visited2[start] = true;

        for (int x : reversed[start]) {
            if (visited2[x]) {
                continue;
            }
            dfsReversed(x);
        }
    }
}
