package DynamicPro;

public class trianglePath {

    static int solve(int i,int j,int n,int[][]tri,Integer dp[][]){
        if(i==n-1) return tri[n-1][j];
        if(dp[i][j]!=null) return dp[i][j];
        int d =tri[i][j]+ solve(i+1,j,n,tri,dp);
        int dg=tri[i][j]+solve(i+1,j+1,n,tri,dp);
        return dp[i][j]=Math.min(d,dg);
    }
    static int solve2(int[][] tri,int n){
        int dp[][]=new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=tri[n-1][j];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d=tri[i][j]+dp[i+1][j];
                int dg=tri[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.min(d,dg);
            }     
        }
        return dp[0][0];
    }
    static int solve3(int[][]tri, int n){
        int base[]=new int[n];
        int next[]=new int[n];
        for(int j=0;j<n;j++) base[j]=tri[n-1][j];

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int d=tri[i][j]+base[j];
                int dg=tri[i][j]+base[j+1];
                next[j]=Math.min(d,dg);
            }
            base=next;
        }
        return base[0];
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        // Integer[][] dp=new Integer[n][n];
        // return solve(0,0,n,triangle,dp);
        return solve3(triangle,n);
    }
}
