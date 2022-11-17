import java.io.*;
import java.util.*;


public class MilkMeasurement {
    static HashMap<Integer, Integer> ids = new HashMap<>(); // <cow id, milk produced>
    static TreeMap<Integer, Integer> produceCnt = new TreeMap<>(new LargeFirst()); // <milk produced, amount of cows>

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        StringTokenizer l1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(l1.nextToken());
        int g = Integer.parseInt(l1.nextToken());

        Measurement[] logs = new Measurement[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int id = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            logs[i] = new Measurement(d, id, u);
            ids.put(id, 0);
        }

        Arrays.sort(logs);

        produceCnt.put(0, n+1);
        int res = 0;

        for (int i=0; i<n; i++) {
            int milkProduced = ids.get(logs[i].id);
            boolean wasBest = milkProduced == produceCnt.firstKey();

            int prevCnt = produceCnt.get(milkProduced);
            produceCnt.put(milkProduced, produceCnt.getOrDefault(milkProduced, 0)-1);
            if (produceCnt.get(milkProduced) == 0) {
                produceCnt.remove(milkProduced);
            }

            milkProduced += logs[i].update;
            ids.put(logs[i].id, milkProduced);
            produceCnt.put(milkProduced, produceCnt.getOrDefault(milkProduced, 0)+1);

            int currCnt = produceCnt.get(milkProduced);
            boolean nowBest = milkProduced == produceCnt.firstKey();

            if (wasBest){
                if (nowBest && currCnt == prevCnt && currCnt == 1) {
                    // now best, still best, and never tied
                    continue;
                }
                res++;
            } else if (nowBest) {
                res++;
            }
        }

        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        pw.println(res);
        pw.close();
    }

    static class Measurement implements Comparable<Measurement> {
        int day;
        int id;
        int update;

        public Measurement(int d, int i, int u) {
            this.day = d;
            this.id = i;
            this.update = u;
        }

        public int compareTo(Measurement o) {
            return Integer.compare(this.day, o.day);
        }
    }

    static class LargeFirst implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return Integer.compare(b, a);
        }
    }
}
