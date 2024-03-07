package DynamicPro;

public class buySell2 {
	public static int solve(int n,int[] arr,int buy){
        if(n==arr.length) return 0;
        int ans=0;
        
        if(buy==1){
            int buykro=0 - arr[n] + solve(n+1,arr,0);
            int buyskip=0 + solve(n+1,arr,1);
            ans=Math.max(buykro,buyskip);
        }else{
            int sellkro=arr[n] + solve(n+1,arr,1);
            int sellskip=0 + solve(n+1,arr,0);
            ans=Math.max(sellkro,sellskip);
        }
        
        return ans;
    }
        public static int solveM(int n,int[] arr,int buy,Integer dp[][]){
        if(n==arr.length) return 0;
        int ans=0;
        if(dp[n][buy]!=null) return dp[n][buy];
        if(buy==1){
            int buykro=0 - arr[n] + solveM(n+1,arr,0,dp);
            int buyskip=0 + solveM(n+1,arr,1,dp);
            ans=Math.max(buykro,buyskip);
        }else{
            int sellkro=arr[n] + solveM(n+1,arr,1,dp);
            int sellskip=0 + solveM(n+1,arr,0,dp);
            ans=Math.max(sellkro,sellskip);
        }
        
        return dp[n][buy]=ans;
    }
    
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        // Integer dp[][]=new Integer[n+1][2];
        
        // int buy=1;
        // return solveM(0,prices,buy,dp);
        int profit=0;
        for(int i=0;i<n-1;i++){
            if(prices[i+1]>prices[i]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}
