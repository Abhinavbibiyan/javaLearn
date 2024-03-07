package DynamicPro;

import java.util.Arrays;

public class pizzaSlice {
	public static int maxSizeSlices(int[] slices) {

		int k = slices.length;
		int[][] dp1 = new int[k + 1][k + 1];
		for (int e[] : dp1) {
			Arrays.fill(e, -1);
		}
		int case1 = solve(0, k - 2, slices, k / 3, dp1);
		int[][] dp2 = new int[k + 1][k + 1];
		for (int e[] : dp2) {
			Arrays.fill(e, -1);
		}
		int case2 = solve(1, k - 1, slices, k / 3, dp2);
		return Math.max(case1, case2);
	}

	static int solve(int index, int endindex, int[] slices, int n, int[][] dp) {
		if (n == 0 || index > endindex)
			return 0;
		if (dp[index][n] != -1) {
			return dp[index][n];
		}
		// include

		int take = 0;

		take = slices[index] + solve(index + 2, endindex, slices, n - 1, dp);
		// exclude
		int notTake = 0;
		notTake = 0 + solve(index + 1, endindex, slices, n, dp);
		return dp[index][n] = Math.max(take, notTake);
	}


	
	public static int maxPizza(int[] slices) {
		int k=slices.length;
		int dp1[][]=new int[k+2][k+2];
		for(int e[]: dp1)
			Arrays.fill(e,0);
		int[][] dp2=new int[k+2][k+2];
		for(int e[]: dp2)
			Arrays.fill(e, 0);
		// include
		int take=0;
		int notTake=0;
		for(int index= k-2;index>=0;index-- ) {
			for(int n=1;n<=k/3;n++)
			{
				take=slices[index]+dp1[index+2][n-1];
				notTake=dp1[index+1][n];
				dp1[index][n]=Math.max(notTake, take);
			}
		}
		int case1=dp1[0][k/3];
		//take=0; notTake=0;
		for(int index=k-1;index>=1;index--) {
			for(int n=1;n<=k/3;n++)
			{
				 take=slices[index] + dp2[index+2][n-1];
				 notTake=dp2[index+1][n];
				 dp2[index][n]=Math.max(take,notTake);
			   }
			}
		int case2=dp2[1][k/3];
		return Math.max(case1, case2);
	}	
	public static int maxPizzaSpace(int[] slices) {
		int k=slices.length;
		int[] cur1=new int[k+2]; // dp[index]=cur
		int[] pre1=new int[k+2]; // dp[index+1]=pre
		int[] next1=new int[k+2]; // dp[index+2]=next
		
		int[] pre2= new int[k+2];
		int[] cur2= new int[k+2];
		int[] next2=new int[k+2];
		
		int take=0,notTake=0;
		
		for(int index=k-2;index>=0;index--) {
			for(int n=1;n<=k/3;n++) {
				//include
				take=slices[index]+ next1[n-1];
				//exclude
				notTake=cur1[n];
				pre1[n]=Math.max(notTake, take);
				
			}
			next1=cur1;
			cur1=pre1;
			 
		}
		int case1=cur1[k/3];
		
		for(int index=k-1;index>=1;index--) {
			for(int n=1;n<=k/3;n++) {
				//included
				take=slices[index]+ next2[n-1];
				// exclude
				notTake=cur2[n];
				
				pre2[n]=Math.max(notTake, take);
			}
			next2=cur2;
			cur2=pre2;
			
		}
		int case2=cur2[k/3];
		
		return Math.max(case1, case2);
	}
	

	public static void main(String[] args) {

		int[] arr= {1,2,3,4,5,6};
		System.out.println(maxPizza(arr));
		System.out.println();
		System.out.println(maxSizeSlices(arr));
		System.out.println();
		System.out.println(maxPizzaSpace(arr));
	}

}
