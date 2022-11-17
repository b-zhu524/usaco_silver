import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class MilkMeasurement2 {
    static int solve(List<Measure> measureList) {
        Collections.sort(measureList);

        Map<Integer, Integer> cowMilkMap= new HashMap<>();
        SortedMap<Integer, Set<Integer>> milkCowMap = new TreeMap<>();

        // init
        Set<Integer> cows = new HashSet<>();
        for (Measure m : measureList) {
            cowMilkMap.put(m.cow, 0);
            cows.add(m.cow);
        }
        milkCowMap.put(0, cows);

        // simulation
        int res = 0;
        for (Measure m : measureList) {
            // remember prev winner
            int prevMaxMilk = milkCowMap.lastKey();
            Set<Integer> prevWinners = milkCowMap.get(prevMaxMilk);

            boolean isPrevWinner = prevWinners.contains(m.cow);
            int prevWinnerdSize = prevWinners.size();

            // update
            int prevMMilk = cowMilkMap.get(m.cow);
            int newMMilk = prevMMilk + m.delta;
            cowMilkMap.put(m.cow, newMMilk);

            Set<Integer> prevGrp = milkCowMap.get(prevMMilk);
            prevGrp.remove(m.cow);
            if (prevGrp.isEmpty()) {
                milkCowMap.remove(prevMMilk);
            }

            Set<Integer> newGrp = milkCowMap.get(newMMilk);
            if (newGrp == null) {
                newGrp = new HashSet<>();
            }
            newGrp.add(m.cow);
            milkCowMap.put(newMMilk, newGrp);

            // find new winner
            int newMaxMilk = milkCowMap.lastKey();
            Set<Integer> newWinners = milkCowMap.get(newMaxMilk);

            if (isPrevWinner && !newWinners.contains(m.cow)) {
                res += 1;
            }
            if (!isPrevWinner && newWinners.contains(m.cow)) {
                res += 1;
            }
            if (isPrevWinner && newWinners.contains(m.cow) && prevWinnerdSize != newWinners.size()) {
                res += 1;
            }
        }
        if (res==0){
            res = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            // read input
            BufferedReader br = new BufferedReader( new FileReader("measurement.in") );
            String[] tmpArr = br.readLine().trim().split(" ");
            int N = Integer.parseInt(tmpArr[0]);
//            Measure[] measures = new Measure[N];
            List<Measure> measureList = new ArrayList<>(N);
            int G = Integer.parseInt(tmpArr[1]);
            for (int i=0; i<N; i++) {
                tmpArr = br.readLine().trim().split(" ");
                int day = Integer.parseInt(tmpArr[0]);
                int cow = Integer.parseInt(tmpArr[1]);
                int delta = Integer.parseInt(tmpArr[2]);
                Measure m = new Measure(day, cow, delta);
                measureList.add(m);
            }
            br.close();

            // find solution
            int res = solve(measureList);

            // write output
            BufferedWriter bw = new BufferedWriter( new FileWriter("measurement.out") );
            bw.write(res + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////
    static class Measure implements Comparable<Measure> {
        int day;
        int cow;
        int delta;

        public Measure(int day, int cow, int delta) {
            this.day = day;
            this.cow = cow;
            this.delta = delta;
        }

        @Override
        public int compareTo(Measure other) {
            return this.day - other.day;
        }
    }
}
