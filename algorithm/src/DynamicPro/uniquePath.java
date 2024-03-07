package DynamicPro;

public class uniquePath {
	public static int solve(int m,int n){
		if(m==0 && n==0) return 1;
		if(m<0 || n< 0) return 0;
		int up=solve(m-1,n);
		int left=solve(m,n-1);
		return up+left;
	}
	public static int solve1(int m,int n ,int[][]dp){
		if(m==0 && n==0) return 1;
		if(m <0 || n< 0)  return 0;
		if(dp[m][n] !=-1) return dp[m][n];
		int up=solve1(m-1,n,dp);
		int left=solve1(m,n-1,dp);
		dp[m][n]=up+left;
		return dp[m][n];
	}
	public static int solve2(int m,int n){
		int dp[][]=new int[m][n];
		// dp[m-1][n-1]=1;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0 && j==0) dp[i][j]=1;
				else{
					int down=0;
					int right=0;
					if(i>0) down=dp[i-1][j];
					if(j>0) right=dp[i][j-1];
					dp[i][j]=down+right;
				}
			}
		}
		return dp[m-1][n-1];
	}
	public static int solve3(int m,int n){
		int temp[]=new int[n];
		
		for(int i=0;i<m;i++){
			int curr[]=new int [n];
			for(int j=0;j<n;j++){
				if(i==0 && j==0) curr[j]=1;
				else{
				int up=0;int down=0;
				if(i>0) up=temp[j];
				if(j>0) down=curr[j-1];
				curr[j]=up+down;
				}
			}
			temp=curr;
		}
		return temp[n-1];
	}
	public static int uniquePaths(int m, int n) {
		// Write your code here.
		// return solve(m-1,n-1);
		// int dp[][]=new int[m+1][n+1];
		// for(int[] col: dp){
		// 	Arrays.fill(col,-1);
		// }
		return solve3(m,n);
	}
}
