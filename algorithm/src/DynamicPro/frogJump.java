package DynamicPro;

import java.util.Arrays;

public class frogJump {
	public static int solve(int cost[],int n) {
		if(n==1) return cost[1];
		if(n==0) return cost[0];
		int ans=Math.min(solve(cost,n-1),solve(cost,n-2))+cost[n];
		return ans;	
	}
	public static int solve1(int cost[],int n,int[] dp) {
		if(n==0) return cost[0];
		if(n==1) return cost[1];
		if(dp[n]!=-1) return dp[n];
		int ans=Math.min(solve1(cost,n-1,dp),solve1(cost, n-2,dp))+cost[n];
		dp[n]=ans;
		return dp[n];
	}
	public static int solve2(int cost[],int n) {
		int[] dp=new int[n+1];
		dp[0]=cost[0];
		dp[1]=cost[1];
		for(int i=2;i<n;i++) {
			dp[i]=Math.min(dp[i-1], dp[i-2])+cost[i];
		}
		return Math.min(dp[n-1],dp[n-2]);
	}
	public static int solve3(int[] cost,int n) {
		int pre2=cost[0];
		int pre1=cost[1];
		for(int i=2;i<n;i++) {
			int curr=Math.min(pre1, pre2)+cost[i];
			pre2=pre1;
			pre1=curr;
		}	
		return Math.min(pre2, pre1);
	}
	public static void main(String[] args) {
		
		int N = 3;
		int cost[] = {10, 15, 20};
		int ans=Math.min(solve(cost,N-2),solve(cost,N-1));
		System.out.println(ans);
		int dp[]=new int[N+1];
		Arrays.fill(dp, -1);
		int ans1=Math.min(solve1(cost,N-2,dp),solve1(cost,N-1,dp));
		System.out.println(ans1);
		System.out.println(solve2(cost,N));
		System.out.println(solve3(cost,N));
	}
}
