package DynamicPro;

public class TriangulationofPolygon {
	public int solve(int values[],int i,int k,Integer[][] dp){
        if(i+1==k) return 0;
        int ans=Integer.MAX_VALUE;
        if(dp[i][k]!=null) return dp[i][k];
        for(int j=i+1;j<k;j++){
            ans=Math.min(ans,values[i]*values[j]*values[k]+
                            solve(values,i,j,dp)+solve(values,j,k,dp));
                            
        }
        return dp[i][k]=ans;
    }
     public int solveTab(int[]values,int n){
        int[][]dp=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int k=i+2;k<n;k++){
                int ans=Integer.MAX_VALUE;
                    for(int j=i+1;j<k;j++){
                        ans=Math.min(ans,values[i]*values[j]*values[k]+dp[i][j]+dp[j][k]);
                         
                        dp[i][k]=ans;         
                    }   
            }
        }
        return dp[0][n-1];
    }
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        // Integer[][] dp=new Integer[n+1][n+1];
        // return solve(values,0,n-1,dp);
        return solveTab(values,n);
    }
}
