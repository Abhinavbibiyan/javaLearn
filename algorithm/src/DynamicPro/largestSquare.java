package DynamicPro;

public class largestSquare {
 static int solve(int n,int m,int[][] mat,int[] maxi,Integer[][]dp){
     if(n>=mat.length || m>=mat[0].length ) 
         return 0;
     if(dp[n][m]!=null) return dp[n][m];
     int up=solve(n,m+1,mat,maxi,dp);
    
     int dig=solve(n+1,m+1,mat,maxi,dp);
    
     int left=solve(n+1,m,mat,maxi,dp);
    
    
     if(mat[n][m]== 1){
         int ans= 1+ Math.min(up,Math.min(left,dig)); 
         maxi[0]=Math.max(ans,maxi[0]);
         return dp[n][m]=ans;
     }else{
         return dp[n][m]=0;
     }        
    
 }
    static void solve2(int n,int m,int[][] mat,int[]maxi){
        int[][] dp=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
            int up=dp[i][j+1];
            int left=dp[i+1][j];
            int dig=dp[i+1][j+1];
            if(mat[i][j]==1){
                int ans=1+Math.min(up,Math.min(left,dig));
                maxi[0]=Math.max(maxi[0],ans);
                dp[i][j]=ans;
            }else{
                dp[i][j]=0;
            }
        }    
    }
}
    static void solve3(int n,int m,int[][] mat,int[]maxi){
        int[] next=new int[m+1];
        int[] cur=new int[m+1];
        for(int i=n-1;i>=0;i--){ 
            for(int j=m-1;j>=0;j--){
            int up=next[j+1];
            int left=next[j];
            int dig=cur[j+1];
            if(mat[i][j]==1){
                int ans=1+Math.min(up,Math.min(left,dig));
                maxi[0]=Math.max(maxi[0],ans);
                cur[j]=ans;
            }else{
                cur[j]=0;
            }
            }    
            next=cur.clone();
    }    
    
}
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        int maxi[]={0};
        // Integer[][] dp=new Integer[n][m];
        // solve(0,0,mat,maxi,dp);
        // return maxi[0];
        solve3(n,m,mat,maxi);
        return maxi[0];
        
    }

}
