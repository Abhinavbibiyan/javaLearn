package DynamicPro;

import java.util.Arrays;

public class minPerfectSquare {
 public static	int solve(int n) {
		if(n==0) {
			return 0;
		}
		int ans=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			ans=Math.min(ans, 1+solve(n-i*i));
		}
		return ans;
	}
	public static int solveDP(int n,int[] dp) {
		if(n==0) {
			return 0;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int ans=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			ans=Math.min(ans, 1+solveDP(n-i*i,dp));
		}
		return dp[n]= ans;
	}
	public static int solveTab(int N) {
		int[] dp=new int[N+1];
		Arrays.fill(dp, 0);
		for(int n=1;n<=N;n++) {
			int ans=Integer.MAX_VALUE;
			for(int i=1;i*i<=n;i++) {
				ans=Math.min(ans, 1+dp[n-i*i]);
			}
			  dp[n]=ans;
		}
		return dp[N];
	
	}
	

	public static void main(String[] args) {
		int n = 12 ;
		System.out.println(solve(n));
		int[] dp=new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(solveDP(n,dp));
		System.out.println(solveTab(n));
	}
}
