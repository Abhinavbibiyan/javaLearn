package DynamicPro;

import java.util.Arrays;

public class roopLength {
	public static int solve(int n,int a,int b,int c,int[]dp) {
		if(n==0) {
			return 0;
			
		}
		if(n<=0) {
			return Integer.MIN_VALUE;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		int Aans=solve(n-a,a,b,c,dp);
		int Bans=solve(n-b,a,b,c,dp);
		int Cans=solve(n-c,a,b,c,dp);
		return dp[n]=1+Math.max(Cans, Math.max(Aans, Bans));
	}
 public static void main(String[] args) {
	int n=17;
	int[] dp=new int[n+1];
	Arrays.fill(dp, -1);
	int a=10;
	int b=3;
	int c=11;
	int ans=solve( n, a,  b,  c, dp );
	if(ans<=0) {
		System.out.println("-1");
	}else 
		System.out.println(ans);
}
}
