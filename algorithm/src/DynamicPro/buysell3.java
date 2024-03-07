package DynamicPro;

public class buysell3 {
	public static int solve(int n,int[] arr,int buy,int limit,Integer[][][]dp){
        if(n==arr.length) return 0;
        if(limit==0) return 0;
        if(dp[n][buy][limit]!=null) return dp[n][buy][limit];
        int ans=0;
        if(buy==1){
            int buykro= solve(n+1,arr,0,limit,dp)-arr[n];
            int buyskip=solve(n+1,arr,1,limit,dp);
            ans=Math.max( buykro,buyskip);
        }else{
            int sellkro= arr[n]+solve(n+1,arr,1,limit-1,dp);
            int sellskip=solve(n+1,arr,0,limit,dp);
            ans=Math.max(sellkro,sellskip);
        }
        return dp[n][buy][limit]= ans;
    }
    public static int solveT(int n,int[]arr){
        int[][][]dp=new int[n+1][2][3];
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int limit=1;limit<3;limit++){
                    int ans=0;
                    if(buy==1){
                        int buykro= dp[i+1][0][limit]-arr[i];
                        int buyskip=dp[i+1][1][limit];
                        ans=Math.max( buykro,buyskip);
                    }else{
                        int sellkro= arr[i]+dp[i+1][1][limit-1];
                        int sellskip=dp[i+1][0][limit];
                        ans=Math.max(sellkro,sellskip);
                    }
                    dp[i][buy][limit]= ans;
                }
            }
        }
        return dp[0][1][2];
    }
    public static int maxProfit(int n, int[] price) {
        // code here
        // Integer[][][] dp=new Integer[n+1][2][3];
        // int buy=1;
        // return solve(0,price,buy,2,dp);
        return solveT(n,price);
    }
}
