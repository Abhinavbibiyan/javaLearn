package DynamicPro;

public class longestCsupersequence {
	public static int solve(String s,String r,int m,int n){
	    int dp[][]=new int[m+1][n+1];
	    int ans=0;
	    for(int i=m-1;i>=0;i--){
	        for(int j=n-1;j>=0;j--){
	            if(s.charAt(i)==r.charAt(j)){
	                ans=1+dp[i+1][j+1];  
	            }else{
	                ans=Math.max(dp[i+1][j],dp[i][j+1]);
	            }
	            dp[i][j]=ans;
	        }
	    }
	    return dp[0][0];
	}
	    //Function to find length of shortest common supersequence of two strings.
	    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
	    {
	        //Your code herE
	        return m+n-solve(X,Y,m,n);
	    }
	    public static void main(String[] args) {
			String X = "abcd", Y = "xycd";
		}
}
