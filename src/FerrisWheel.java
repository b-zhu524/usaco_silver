import java.io.*;
import java.util.*;


public class FerrisWheel {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer l1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(l1.nextToken());
		int x = Integer.parseInt(l1.nextToken());

		Integer[] fatKids = new Integer[n];
		// optimization to pass test case 10
		String[] weightString = br.readLine().split(" ");

		for (int i=0; i<n; i++) {
			fatKids[i] = Integer.parseInt(weightString[i]);
		}

		int res = solve(n, x, fatKids);
		System.out.println(res);
	}

	static int solve(int n, int x, Integer[] fatKids) {
		Arrays.sort(fatKids);
		int res = n;

		int i = 0;
		int j = n-1;
		while (i < n && j >= 0 && fatKids[j]+fatKids[i] > x) {
			j--;
		}

		while (i < n && j >= 0 && i < j){
			if (fatKids[i]+fatKids[j] <= x) {
				res--;
				i++;
				j--;
			} else {
				j--;
			}
		}
		return res;
	}
}
