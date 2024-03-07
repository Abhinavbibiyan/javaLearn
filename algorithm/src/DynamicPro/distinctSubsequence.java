package DynamicPro;

public class distinctSubsequence {
	public static int solve(String s,String t,int i,int j,Integer[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=solve(s,t,i-1,j-1,dp)+solve(s,t,i-1,j,dp);
        }
        return dp[i][j]=solve(s,t,i-1,j,dp);
    }
    public static int solveT(String s,String t){
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
    public int solveO(String s,String t){
        int n=s.length();
        int m=t.length();
        int cur[]=new int[m+1];
        int pre[]=new int[m+1];
        pre[0]=cur[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    cur[j]=pre[j-1]+pre[j];
                }else{
                    cur[j]=pre[j];
                }
                
            }
            pre=cur.clone();
        }
        return pre[m];
    }
        public static int solveO1(String s,String t){
        int n=s.length();
        int m=t.length();
        int cur[]=new int[m+1];
        int pre[]=new int[m+1];
        pre[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    pre[j]=pre[j-1]+pre[j];
                }   
            }
        }
        return pre[m];
    }
    public static int numDistinct(String s, String t) {
        // int n=s.length();
        // int m=t.length();
        // Integer[][] dp=new Integer[n+1][m+1];
        return solveO1(s,t);
    }
    public static void main(String[] args) {
		String s ="adbdadeecadeadeccaeaabdabdbcdabdddda"
				+ "bcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddce"
				+ "bddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaaca"
				+ "dbdccabddaddacdddc";
		String t ="bcddceeeebecbc";
		System.out.println(numDistinct(s,t));
	}
}
