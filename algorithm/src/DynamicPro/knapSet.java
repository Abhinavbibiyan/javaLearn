package DynamicPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class knapSet {
	static int solveTab(int[] val, int[] wt, int i, int cap,int[][] dp) {
		if (i == val.length || cap == 0) {
			return 0;
		}
		if(dp[i][cap]!=-1) {
			return dp[i][cap];
		}
		int inc = 0;
		if (cap >= wt[i]) {
			inc = val[i] + solveTab(val, wt, i + 1, cap - wt[i],dp);

		}
		int exc = 0 + solveTab(val, wt, i + 1, cap,dp);
		
		return dp[i][cap]=Math.max(inc, exc);
	}

	static int solve(int[] val, int[] wt, int i, int cap) {
		if (i == val.length || cap == 0) {
			return 0;
		}
		int inc = 0;
		if (cap >= wt[i]) {
			inc = val[i] + solve(val, wt, i + 1, cap - wt[i]);

		}
		int exc = 0 + solve(val, wt, i + 1, cap);
		return Math.max(inc, exc);
	}

	public static void main(String args[]) {
		int w = 10;
		int n = 4;
		int[] val = { 20, 30, 10, 50 };
		int[] wt = { 1, 3, 4, 6 };
//		int[] val = { 5, 4, 8, 6};
//		int[] wt = { 1, 2, 4, 5 };

		// Populate base cases
		int[][] mat = new int[n + 1][w + 1];
		for (int r = 0; r < w + 1; r++) {
			mat[0][r] = 0;
		}
		for (int c = 0; c < n + 1; c++) {
			mat[c][0] = 0;
		}
		// Main logic
		for (int item = 1; item <= n; item++) {
			for (int capacity = 1; capacity <= w; capacity++) {
				int maxValWithoutCurr = mat[item - 1][capacity]; // This is guaranteed to exist
				int maxValWithCurr = 0; // We initialize this value to 0

				int weightOfCurr = wt[item - 1]; // We use item -1 to account for the extra row at the top
				if (capacity >= weightOfCurr) { // We check if the knapsack can fit the current item
					maxValWithCurr = val[item - 1]; // If so, maxValWithCurr is at least the value of the current item

					int remainingCapacity = capacity - weightOfCurr; // remainingCapacity must be at least 0
					maxValWithCurr += mat[item - 1][remainingCapacity]; // Add the maximum value obtainable with the
																		// remaining capacity
				}
				// Pick the larger of the two
				mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
			}
		}

		System.out.println(mat[n][w]); // Final answer
		System.out.println(Arrays.deepToString(mat)); // Visualization of the table

		System.out.println();
		System.out.println(solve(val, wt, 0, w));
		/// try with arraylist
		
	//	ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
//		ArrayList<Integer> dp[]=new ArrayList[n];
//		for(int i=0;i<n+1;i++) {
//			dp[i]=new ArrayList<Integer>(w+1);
//			Collections.fill(dp[i], -1);
//		}
//		for(int i=0;i<n+1;i++) {
//		for(Integer e: dp[i].get(i)) {
//			System.out.println(e);
//		}
//	
//		}
		int[][] dp=new int[n+1][w+1];
	//	Arrays.fill(dp, -1);
		for(int i=1;i<n+1;i++) {
			//Arrays.fill(dp[i], -1);
			for(int k=1;k<w+1;k++) {
				dp[i][k]=-1;
			}
		}
 
		System.out.println(solveTab(val,wt,0,w,dp));
		System.out.println(Arrays.deepToString(dp));
		
	}

}
