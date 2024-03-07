package DynamicPro;

public class matrixPath {
    static int mod= (int) 1e9 + 7;
    static long dpHelp(int m,int n,long[][] dp){
        if(m<0||n<0) return 0;
        if(m==0 && n==0) return  1;
        
        if(dp[m][n]!=0) return dp[m][n]%mod;
        
        return dp[m][n]= (dpHelp(m-1,n,dp)%mod + dpHelp(m, n-1, dp)%mod)%mod;
   
        
    }
   
   long numberOfPaths(int m, int n)
   {
       // code here
        long dp[][]=new long[m+1][n+1];
       
       // long ans=count(0,0,m,n,dp);
       // return ans;
       
       
      // return dpHelp(m-1,n-1,dp);
      
      for(int i=1;i<=m;i++){
          for(int j=1;j<=n;j++){
              if(i==1 && j==1) dp[i][j]=1;
              else{
                  
                  dp[i][j]=(dp[i][j-1]%mod+dp[i-1][j]%mod)%mod;
                  
              }
          }
      }
       return dp[m][n];
   }
   
   public static void main(String[] args) {
	
}
}
