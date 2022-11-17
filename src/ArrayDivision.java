import java.io.*;
import java.util.*;

public class ArrayDivision {
    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer l1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(l1.nextToken());
        k = Integer.parseInt(l1.nextToken());

        int[] arr = new int[n];
        long s = 0;

        StringTokenizer l2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int v = Integer.parseInt(l2.nextToken());
            arr[i] = v;
            s += v;
        }

        long min = 0;
        long max = s;

        long res = binarySearch(min, max, arr);
        System.out.println(res);
    }

    public static long binarySearch(long min, long max, int[] arr) {
        long s = works(min, arr);

        if (min==max) return min;
        if (min+1==max) {
            if (s > -1) return min;
            return max;
        }

        long mid = (min + max)/2;

        long ms = works(mid, arr);
        if (ms > -1) {
            return binarySearch(min, mid, arr);
        } else {
            return binarySearch(mid+1, max, arr);
        }

    }

    public static long works(long minSum, int[] arr) {
        long subarrays = 1;
        long maxSum = 0;

        long currSum = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] > minSum) {
                return -1;
            }

            if (currSum + arr[i] <= minSum) {
                currSum += arr[i];
            } else {
                subarrays++;
                maxSum = Math.max(maxSum, currSum);
                currSum = arr[i];
            }
        }
        if (subarrays <= k) {
            return maxSum;
        } else {
            return -1;
        }
    }
}


