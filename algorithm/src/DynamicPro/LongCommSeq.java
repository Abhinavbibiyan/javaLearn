package DynamicPro;

public class LongCommSeq {
public static void main(String[] args) {
	
	String s="ABCBA";
	String t="AECB";
	int n=s.length();
	int m=t.length();
	int [][]dp=new int[n+1][m+1];
//	for(int i=0;i<=n;i++) {
//		dp[0][i]=0;
//	}
//	for(int j=0;j<=m;j++) {
//		dp[j][0]=0;
//	}
	for(int i=1;i<=n;i++) {
		for(int j=1;j<=m;j++) {
			dp[i][j]=-1;
		}
		 
	}
	int [][]DP=new int[n+1][m+1];
	
	
	int leng= lcs(s,t,n,m,dp);
	System.out.println(leng);
	System.out.println(TableLCS(s,t,n,m,DP));
}

public static int  lcs(String s, String t, int n, int m, int[][] dp) {
	 if(n==0||m==0) return 0;
	 if(dp[n][m]!=-1) return dp[n][m];
	 if(s.charAt(n-1)==t.charAt(m-1)) return dp[n][m]=1+ lcs(s,t,n-1,m-1,dp);
	 else {
		return Math.max(lcs(s,t,n,m-1,dp), lcs(s,t,n-1,m,dp));
	 }
	 
}
public static int  TableLCS(String s, String t, int n, int m, int[][] DP) {

	for(int i=1;i<=n;i++) {
		for(int j=1;j<=m;j++) {
			if(s.charAt(i-1)==t.charAt(j-1))  
				 DP[i][j] = 1 + DP[i-1][j-1];
			else
				  DP[i][j]=Math.max(DP[i-1][j], DP[i][j-1]);
		}
		 
	}
	return DP[n][m];
	
}
}
