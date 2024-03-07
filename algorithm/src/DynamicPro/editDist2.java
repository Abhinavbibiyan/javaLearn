package DynamicPro;

public class editDist2 {
	public int solveT(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int j=0;j<m;j++){
                dp[n][j]=m-j;
            }
            for(int i=0;i<n;i++){
                dp[i][m]=n-i;
            }
        int ans=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=dp[i+1][j+1];
                }else{
                    int inser=1+dp[i][j+1];
                    int del=1+dp[i+1][j];
                    ans=Math.min(inser,del);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
    public int solve(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        int ans=0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    ans=1+dp[i+1][j+1];
                }else{
                    ans=Math.max(dp[i+1][j],dp[i][j+1]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[0][0];
    }
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n=str1.length();
        int m=str2.length();
	    int len= solve(str1,str2);
	    return m+n-2*(len);
	} 
}
